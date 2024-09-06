package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.ServerController;
import communication.Operation;
import domain.Klijent;
import domain.NapomenaZaUslugu;
import domain.Termin;
import domain.Usluga;
import domain.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ivana
 */
public class ThreadClient extends Thread {

    private final Socket clientSocket;
    private final Sender sender;
    private final Receiver receiver;
    private final ServerController controller;
    private Zaposleni loginUser;
    private final ThreadServer server;
    private List<Zaposleni> zaposleni = new ArrayList<>();

    public ThreadClient(Socket clientSocket, ThreadServer server) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.sender = new Sender(clientSocket);
        this.receiver = new Receiver(clientSocket);
        this.controller = new ServerController();
    }

    @Override
    public void run() {
        try {
            while (!server.isServerStopped()) {
                Request request = (Request) receiver.receive();
                Response response = new Response();

                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Zaposleni zaposlen = (Zaposleni) request.getArgument();
                            if (server.notLogin(zaposlen)) {
                                response.setResult(controller.login(zaposlen));
                                loginUser = zaposlen;
                                zaposleni.add(zaposlen);
                                server.addLoggedInZaposleni(zaposlen);
                            } else {
                                throw new Exception("Zaposleni je vec prijavljen");
                            }
                            break;

                        case LOGOUT:
                            Zaposleni zaposlenLogOut = (Zaposleni) request.getArgument();
                            server.logout(zaposlenLogOut);
                            loginUser = null; 
                            break;

                        case ADD_KLIJENT:
                            Klijent klijnt = (Klijent) request.getArgument();
                            controller.addKlijent(klijnt);
                            response.setResult(klijnt);
                            break;

                        case GET_TIP_KLIJENTA:
                            response.setResult(controller.getListTipKlijenta());
                            break;

                        case GET_KLIJENTI:
                            response.setResult(controller.getListKlijent());
                            break;

                        case UPDATE_KLIJENT:
                            Klijent k = (Klijent) request.getArgument();
                            controller.updateKlijent(k);
                            response.setResult(k);
                            break;

                        case DELETE_KLIJENT:
                            Klijent kl = (Klijent) request.getArgument();
                            controller.deleteKlijent(kl);
                            break;

                        case GET_VRSTA_USLUGE:
                            response.setResult(controller.getListVrstaUsluge());
                            break;

                        case GET_TIP_NAPOMENE:
                            response.setResult(controller.getListTipNapomene());
                            break;

                        case ADD_USLUGA:
                            Usluga usluga = (Usluga) request.getArgument();
                            controller.addUsluga(usluga);
                            response.setResult(usluga);
                            break;

                        case ADD_NAPOMENA_ZA_USLUGU:
                            NapomenaZaUslugu napomena = (NapomenaZaUslugu) request.getArgument();
                            controller.addNapomena(napomena);
                            response.setResult(napomena);
                            break;

                        case GET_USLUGE_ALL:
                            response.setResult(controller.getAllUsluge());
                            break;

                        case GET_FILTERED_USLUGE:
                            String naziv = (String) request.getArgument();
                            response.setResult(controller.getListUslugaByNaziv(naziv));
                            break;

                        case GET_NAPOMENE_USLUGA:
                            Usluga u = (Usluga) request.getArgument();
                            response.setResult(controller.getListNapomena(u));
                            break;

                        case DELETE_USLUGA:
                            Usluga uslugaToDelete = (Usluga) request.getArgument();
                            controller.deleteUsluga(uslugaToDelete);
                            break;

                        case GET_FILTERED_KLIJENTI:
                            String imePrezime = (String) request.getArgument();
                            response.setResult(controller.getListKlijentByImePrezime(imePrezime));
                            break;

                        case ADD_TERMIN:
                            Termin termin = (Termin) request.getArgument();
                            controller.addTermini(termin);
                            response.setResult(termin);
                            break;

                        case GET_TERMINI:
                            response.setResult(controller.getAllTermini());
                            break;

                        case DELETE_TERMIN:
                            Termin t = (Termin) request.getArgument();
                            controller.deleteTermin(t);
                            break;

                        case NADJI_TERMINE:
                            Timestamp datum = (Timestamp) request.getArgument();
                            List<Termin> termini = (List<Termin>) controller.getListTermin(datum);
                            response.setResult(termini);
                            break;
                        case UPDATE_USLUGA:
                            Usluga uslugaUpdate = (Usluga) request.getArgument();
                            controller.updateUsluga(uslugaUpdate);
                            break;

                        default:
                            throw new IllegalArgumentException("Unsupported operation: " + request.getOperation());
                    }
                } catch (Exception e) {
                    response.setException(e);
                }

                sender.send(response);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeResources();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void closeResources() throws IOException {
        if (clientSocket != null && !clientSocket.isClosed()) {
            clientSocket.close();
        }
        if (sender != null) {
            sender.close();
        }
        if (receiver != null) {
            receiver.close();
        }
    }

    public void logout() throws IOException, Exception {
        if (loginUser != null) {
            sender.send(new Request(Operation.LOGOUT, loginUser));
            loginUser = null;
        }
    }

    public void disconnectOnServerShutdown() throws IOException, Exception {
        if (loginUser != null) {
            sender.send(new Request(Operation.LOGOUT, loginUser));
            loginUser = null;
        }
    }

    public Zaposleni getLoginUser() {
        return loginUser;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
