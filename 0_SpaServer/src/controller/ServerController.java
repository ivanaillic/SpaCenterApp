/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Klijent;
import domain.NapomenaZaUslugu;
import domain.Termin;
import domain.TipKlijenta;
import domain.TipNapomeneZaUslugu;
import domain.Usluga;
import domain.VrstaUsluge;
import domain.Zaposleni;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import so.klijent.SOAddKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOGetAllKlijenti;
import so.klijent.SOGetAllKlijentiByImePrezime;
import so.klijent.SOUpdateKlijent;
import so.napomena.SOAddNapomena;
import so.napomena.SOGetNapomena;
import so.termin.SOAddTermin;
import so.termin.SODeleteTermin;
import so.termin.SOGetAllTermin;
import so.termin.SOGetAllTerminiByDatum;
import so.tipklijenta.SOGetAllTipKlijenta;
import so.tipnapomene.SOGetAllTipNapomene;
import so.usluga.SOAddUsluga;
import so.usluga.SODeleteUsluga;
import so.usluga.SOGetAllUsluga;
import so.usluga.SOGetAllUslugaByNaziv;
import so.vrstausluge.SOGetAllVrstaUsluge;
import so.zaposleni.SOLogin;
import thread.ThreadClient;
import thread.ThreadServer;
import java.util.logging.Level;
import so.usluga.SOUpdateUsluga;

/**
 *
 * @author Ivana
 */
public class ServerController {

    private List<ThreadClient> clients = new ArrayList<>();

    public Zaposleni login(Zaposleni z) throws Exception {
        try {
            SOLogin loginUser = new SOLogin(z);
            loginUser.execute(z);
            return loginUser.getZaposleni();
        } catch (Exception ex) {
            System.out.println("Greška prilikom prijavljivanja zaposlenog: " + ex.getMessage());
            throw ex;
        }
    }

    public Klijent addKlijent(Klijent klijent) throws Exception {

        SOAddKlijent kl = new SOAddKlijent();
        kl.execute(klijent);
        return kl.getKlijent();
    }

    public Object getListTipKlijenta() throws Exception {
        SOGetAllTipKlijenta getAllTipKlijenta = new SOGetAllTipKlijenta();
        getAllTipKlijenta.execute(new TipKlijenta());
        return getAllTipKlijenta.getTipKlijenta();
    }

    public Object getListKlijent() throws Exception {
        SOGetAllKlijenti getAllKlijenti = new SOGetAllKlijenti();
        getAllKlijenti.execute(new Klijent());
        return getAllKlijenti.getKlijenti();
    }

    public void updateKlijent(Klijent k) throws Exception {

        SOUpdateKlijent updateKlijent = new SOUpdateKlijent();
        updateKlijent.execute(k);
    }

    public void deleteKlijent(Klijent k) throws Exception {

        SODeleteKlijent deleteKlije = new SODeleteKlijent();
        deleteKlije.execute(k);
    }

    public Object getListVrstaUsluge() throws Exception {
        SOGetAllVrstaUsluge getAllVrstaUsluge = new SOGetAllVrstaUsluge();
        getAllVrstaUsluge.execute(new VrstaUsluge());
        return getAllVrstaUsluge.getVrstaUsluge();
    }

    public Object getListTipNapomene() throws Exception {
        SOGetAllTipNapomene getAllTipNapomene = new SOGetAllTipNapomene();
        getAllTipNapomene.execute(new TipNapomeneZaUslugu());
        return getAllTipNapomene.getTipNapomene();
    }

    public Usluga addUsluga(Usluga usluga) throws Exception {
        SOAddUsluga addUsluga = new SOAddUsluga();
        addUsluga.execute(usluga);
        return addUsluga.getUsluga();
    }

    public void addNapomena(NapomenaZaUslugu napomena) throws Exception {
        SOAddNapomena addNapomena = new SOAddNapomena();
        addNapomena.execute(napomena);
    }

    public Object getListUslugaByNaziv(String naziv) throws Exception {
        SOGetAllUslugaByNaziv getAllUslugaByNaziv = new SOGetAllUslugaByNaziv();
        getAllUslugaByNaziv.setNazivUsluge(naziv);
        Usluga u = new Usluga(-1l, naziv, -1, -1, new VrstaUsluge());
        getAllUslugaByNaziv.execute(u);
        return getAllUslugaByNaziv.getFilteredUsluge();
    }

    public Object getAllUsluge() throws Exception {
        SOGetAllUsluga getAll = new SOGetAllUsluga();
        getAll.execute(new Usluga());
        return getAll.getListaUsluga();
    }

    public Object getListNapomena(Usluga u) throws Exception {
        NapomenaZaUslugu npu = new NapomenaZaUslugu();
        npu.setUsluga(u);

        SOGetNapomena getAllNapomena = new SOGetNapomena();
        getAllNapomena.execute(npu);
        return getAllNapomena.getUsluge();

    }

    public void deleteUsluga(Usluga usluga) throws Exception {
        SODeleteUsluga deleteUsluga = new SODeleteUsluga();
        deleteUsluga.execute(usluga);
    }

    public Object getListKlijentByImePrezime(String imePrezime) throws Exception {
        SOGetAllKlijentiByImePrezime getAllKlijenti;

        if (imePrezime != null && !imePrezime.isEmpty()) {
            getAllKlijenti = new SOGetAllKlijentiByImePrezime(imePrezime);
        } else {
            throw new IllegalArgumentException("Morate uneti ime i/ili prezime klijenta.");
        }

        getAllKlijenti.execute(new Klijent());
        return getAllKlijenti.getFilteredKlijenti();
    }

    public void addTermini(Termin termin) throws Exception {
        SOAddTermin addTermin = new SOAddTermin();
        addTermin.execute(termin);
    }

    public Object getAllTermini() throws Exception {
        SOGetAllTermin getAll = new SOGetAllTermin();
        getAll.execute(new Termin());
        return getAll.getListaTermina();
    }

    public void deleteTermin(Termin t) throws Exception {
        SODeleteTermin deleteTermin = new SODeleteTermin();
        deleteTermin.execute(t);
    }

    public Object getListTermin(Timestamp datum) throws Exception {
        SOGetAllTerminiByDatum getTerminiByDatum = new SOGetAllTerminiByDatum(datum);
        getTerminiByDatum.execute(new Termin());
        return getTerminiByDatum.getTermini();
    }

    public void updateUsluga(Usluga novaUsluga) throws Exception {
        SOUpdateUsluga updateTermin = new SOUpdateUsluga();
        updateTermin.execute(novaUsluga);

    }

    public void logout(Zaposleni zaposleni) throws IOException {
        ThreadClient clientToRemove = null;
        for (ThreadClient client : clients) {
            if (zaposleni.equals(client.getLoginUser())) {
                clientToRemove = client;
                break;
            }
        }
        if (clientToRemove != null) {
            clients.remove(clientToRemove);
            try {
                clientToRemove.closeResources();
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
