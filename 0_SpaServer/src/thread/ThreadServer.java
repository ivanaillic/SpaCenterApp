/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import controller.ServerController;
import domain.Zaposleni;
import thread.ThreadClient;

/**
 *
 * @author Ivana
 */
public class ThreadServer extends Thread {

    private boolean serverStopped = false;
    private boolean end = false;
    private Sender sender;
    private Receiver receiver;
    private ServerController controller;
    private List<ThreadClient> clients;
    private List<Zaposleni> ulogovaniZaposleni;

    private ServerSocket serverSocket;

    public ThreadServer() {
        this.controller = new ServerController();
        clients = new ArrayList<>();
        ulogovaniZaposleni = new ArrayList<>();
    }

    public void addLoggedInZaposleni(Zaposleni zaposleni) {
        ulogovaniZaposleni.add(zaposleni);
    }

    public void removeLoggedInZaposleni(Zaposleni zaposleni) {
        ulogovaniZaposleni.remove(zaposleni);
    }

    public List<Zaposleni> getLoggedInZaposleni() {
        return ulogovaniZaposleni;
    }

    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(9000);
           // serverSocket.setSoTimeout(100000);
            while (!end) {
                System.out.println("Waiting for connection...");
                if (serverSocket.isClosed()) {
                    break;
                }
                Socket clientSocket = serverSocket.accept();
                if (serverSocket.isClosed()) {
                    break;
                }
                if (end) {

                    break;
                }
                System.out.println("Connected!");
                ThreadClient clientThread = new ThreadClient(clientSocket, this);
                clientThread.start();
                clients.add(clientThread);
            }

        } catch (IOException ex) {
            if (!end) {
                //ex.printStackTrace();
            }
            //ex.printStackTrace();
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                    System.out.println("Server sokcket closed.");
                }
            } catch (IOException ex) {
                //ex.printStackTrace();
            }
        }
    }

    public boolean notLogin(Zaposleni zaposleni) {
        for (ThreadClient client : clients) {
            if (zaposleni.equals(client.getLoginUser())) {
                return false;
            }
        }
        return true;
    }

    public void logout(Zaposleni zaposleni) throws IOException {
        removeLoggedInZaposleni(zaposleni);
        ThreadClient clientToRemove = null;
        for (ThreadClient client : clients) {
            if (zaposleni.equals(client.getLoginUser())) {
                clientToRemove = client;

            }
        }
        clients.remove(clientToRemove);
    }

 public synchronized void stopServer() throws InterruptedException, Exception {
    System.out.println("Zatvaranje servera...");

    disconnectAllClients();

    for (ThreadClient client : clients) {
        try {
            client.join();
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }


    try {
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
    } catch (IOException ex) {
        //ex.printStackTrace();
    }

    System.out.println("Server je zatvoren.");
    end = true;
    serverStopped = true;
}

public void disconnectAllClients() {
    for (ThreadClient client : clients) {
        try {
            client.logout(); 
            client.closeResources();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    clients.clear();  
}


    public synchronized void shutdown() throws Exception {
        System.out.println("Zatvaranje servera...");
        end = true;
        try {
            stopServer();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        clients.clear();
        serverSocket = null;
    }



    public boolean isServerStopped() {
        return serverStopped;
    }

}
