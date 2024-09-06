/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Klijent;
import domain.NapomenaZaUslugu;
import domain.Termin;
import domain.TipKlijenta;
import domain.TipNapomeneZaUslugu;
import domain.Usluga;
import domain.VrstaUsluge;
import domain.Zaposleni;
import form.termin.PretragaTermina;
import form.usluga.PretragaUsluge;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivana
 */
public class ClientController {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static ClientController instance;
    private PretragaUsluge pu;
    private PretragaTermina pt;

    public PretragaTermina getPt() {
        return pt;
    }

    public void setPt(PretragaTermina pt) {
        this.pt = pt;
    }

    public PretragaUsluge getPu() {
        return pu;
    }

    public void setPu(PretragaUsluge pu) {
        this.pu = pu;
    }

    private ClientController() throws Exception {
        socket = new Socket("localhost", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static ClientController getInstance() throws Exception {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Zaposleni login(Zaposleni z) throws Exception {
        Request request = new Request(Operation.LOGIN, z);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Zaposleni) response.getResult();
        } else if (response.getException().getMessage().equals("Zaposleni je vec prijavljen")) {
            return null;
        } else {
            throw response.getException();
        }
    }

    public Klijent addKlijent(Klijent klijent) throws Exception {

        Request request = new Request(Operation.ADD_KLIJENT, klijent);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Klijent) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public void logout(Zaposleni z) throws Exception {
        try {
            Request request = new Request(Operation.LOGOUT, z);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            }
        } finally {
            closeResources(); 
        }
    }

    private void closeResources() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

    public List<TipKlijenta> getListTipKlijenta() throws Exception {

        Request request = new Request(Operation.GET_TIP_KLIJENTA, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<TipKlijenta>) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public List<Klijent> getListKlijent() throws Exception {
        Request request = new Request(Operation.GET_KLIJENTI, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Klijent>) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public void updateKlijent(Klijent klijent) throws Exception {

        Request request = new Request(Operation.UPDATE_KLIJENT, klijent);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }

    }

    public void deleteKlijent(Klijent k) throws Exception {

        Request request = new Request(Operation.DELETE_KLIJENT, k);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {

        } else {
            System.out.println(response.getException());
            throw response.getException();

        }

    }

    public List<VrstaUsluge> getListVrstaUsluge() throws Exception {
        Request request = new Request(Operation.GET_VRSTA_USLUGE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<VrstaUsluge>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<TipNapomeneZaUslugu> getListTipNapomene() throws Exception {
        Request request = new Request(Operation.GET_TIP_NAPOMENE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<TipNapomeneZaUslugu>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Usluga addUsluga(Usluga usluga) throws Exception {
        Request request = new Request(Operation.ADD_USLUGA, usluga);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Usluga) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addNapomena(NapomenaZaUslugu napomena) throws Exception {

        Request request = new Request(Operation.ADD_STAVKA_TERMINA, napomena);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }

    }

    public List<Usluga> getListUsluga() throws Exception {

        Request request = new Request(Operation.GET_USLUGE_ALL, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Usluga>) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public List<Usluga> getListUsluga(String pretragaNaziv) throws Exception {
        if (pretragaNaziv == null || pretragaNaziv.isEmpty()) {
            throw new IllegalArgumentException("Unesite naziv usluge za pretragu!");
        }
        Request request = new Request(Operation.GET_FILTERED_USLUGE, pretragaNaziv);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() == null) {
            return (List<Usluga>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<NapomenaZaUslugu> getListNapomenaPoUsluzi(Usluga usluga) throws Exception {
        Request request = new Request(Operation.GET_NAPOMENE_USLUGA, usluga);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<NapomenaZaUslugu>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void deleteUsluga(Usluga usluga) throws Exception {
        Request request = new Request(Operation.DELETE_USLUGA, usluga);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public List<Klijent> getListKlijent(String pretraga) throws Exception {
        if (pretraga == null || pretraga.isEmpty()) {
            throw new IllegalArgumentException("Unesite ime, prezime ili oba za pretragu!");
        }
        Request request = new Request(Operation.GET_FILTERED_KLIJENTI, pretraga);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {
            return (List<Klijent>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addTermini(Termin termin) throws Exception {
        Request request = new Request(Operation.ADD_TERMIN, termin);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public List<Termin> getListTermin() throws Exception {
        Request request = new Request(Operation.GET_TERMINI, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Termin>) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public List<Termin> getListTermin(Timestamp datum) throws Exception {
        if (datum == null) {
            throw new IllegalArgumentException("Datum ne može biti null!");
        }

        Request request = new Request(Operation.NADJI_TERMINE, datum);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {
            return (List<Termin>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void deleteTermin(Termin termin) throws Exception {
        Request request = new Request(Operation.DELETE_TERMIN, termin);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void updateUsluga(Usluga novaUsluga) {
        try {
            Request request = new Request(Operation.UPDATE_USLUGA, novaUsluga);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                
            } else {
                throw response.getException();
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
