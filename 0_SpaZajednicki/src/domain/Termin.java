/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ivana
 */
public class Termin extends AbstractDomainObject implements Serializable {

    private Klijent klijent;
    private Usluga usluga;
    private Timestamp datumVremeTermina;
    private int brojProstorije;
    private String napomena;
    private Vaucer vaucer;
    private double konacnaCena;

    public Termin() {
    }

    public Termin(Klijent klijent, Usluga usluga, Timestamp datumVremeTermina, int brojProstorije, String napomena, Vaucer vaucer, double konacnaCena) {
        this.klijent = klijent;
        this.usluga = usluga;
        this.datumVremeTermina = datumVremeTermina;
        this.brojProstorije = brojProstorije;
        this.napomena = napomena;
        this.vaucer = vaucer;
        this.konacnaCena = konacnaCena;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Timestamp getDatumVremeTermina() {
        return datumVremeTermina;
    }

    public void setDatumVremeTermina(Timestamp datumVremeTermina) {
        this.datumVremeTermina = datumVremeTermina;
    }

    public int getBrojProstorije() {
        return brojProstorije;
    }

    public void setBrojProstorije(int brojProstorije) {
        this.brojProstorije = brojProstorije;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Vaucer getVaucer() {
        return vaucer;
    }

    public void setVaucer(Vaucer vaucer) {
        this.vaucer = vaucer;
    }

    public double getKonacnaCena() {
        return konacnaCena;
    }

    public void setKonacnaCena(double konacnaCena) {
        this.konacnaCena = konacnaCena;
    }

    @Override
    public String toString() {
        return "Termin{" + "klijent=" + klijent + ", usluga=" + usluga + ", datumVremeTermina=" + datumVremeTermina + ", brojProstorije=" + brojProstorije + ", napomena=" + napomena + ", vaucer=" + vaucer + ", konacnaCena=" + konacnaCena + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.klijent);
        hash = 97 * hash + Objects.hashCode(this.usluga);
        hash = 97 * hash + Objects.hashCode(this.datumVremeTermina);
        hash = 97 * hash + this.brojProstorije;
        hash = 97 * hash + Objects.hashCode(this.napomena);
        hash = 97 * hash + Objects.hashCode(this.vaucer);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.konacnaCena) ^ (Double.doubleToLongBits(this.konacnaCena) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Termin other = (Termin) obj;
        if (this.brojProstorije != other.brojProstorije) {
            return false;
        }
        if (Double.doubleToLongBits(this.konacnaCena) != Double.doubleToLongBits(other.konacnaCena)) {
            return false;
        }
        if (!Objects.equals(this.napomena, other.napomena)) {
            return false;
        }
        if (!Objects.equals(this.klijent, other.klijent)) {
            return false;
        }
        if (!Objects.equals(this.usluga, other.usluga)) {
            return false;
        }
        if (!Objects.equals(this.datumVremeTermina, other.datumVremeTermina)) {
            return false;
        }
        return this.vaucer == other.vaucer;
    }

    @Override
    public String getTableName() {
        return "termin";
    }

    @Override
    public String getColumnsForInsert() {
        return "(sifraKlijenta, sifraUsluge, datumVremeTermina, brojProstorije, napomena, vaucer, konacnaCena)";
    }

    @Override
    public String getParamsForInsert() {
        return "(?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        Termin termin = (Termin) domainObject;
        statement.setLong(1, termin.getKlijent().getSifraKlijenta());
        statement.setLong(2, termin.getUsluga().getSifraUsluge());
        statement.setTimestamp(3, new Timestamp(termin.getDatumVremeTermina().getTime()));
        statement.setInt(4, termin.getBrojProstorije());
        statement.setString(5, termin.getNapomena());
        statement.setString(6, termin.getVaucer().name());
        statement.setDouble(7, termin.getKonacnaCena());
    }

    @Override
    public String getColumnsForUpdate() {
        return "sifraKlijenta = ?, sifraUsluge = ?, datumVremeTermina = ?, brojProstorije = ?, napomena = ?, vaucer = ?, konacnaCena = ?";
    }

    @Override
    public String getParamsForUpdate() {
        return "sifraKlijenta = ?, sifraUsluge = ?, datumVremeTermina = ?, brojProstorije = ?, napomena = ?, vaucer = ?, konacnaCena = ?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        Termin termin = (Termin) domainObject;
        statement.setLong(1, termin.getKlijent().getSifraKlijenta());
        statement.setLong(2, termin.getUsluga().getSifraUsluge());
        statement.setTimestamp(3, new Timestamp(termin.getDatumVremeTermina().getTime()));
        statement.setInt(4, termin.getBrojProstorije());
        statement.setString(5, termin.getNapomena());
        statement.setString(6, termin.getVaucer().name());
        statement.setDouble(7, termin.getKonacnaCena());
    }

    @Override
    public String getPrimaryKey() {
        return "sifraKlijenta";
    }

    @Override
public Long getPrimaryKeyValue() {
    return this.getKlijent().getSifraKlijenta();

}


    @Override
    public String alias() {
        return "";
    }

   @Override
public String join() {
    return " JOIN klijent ON termin.sifraKlijenta = klijent.sifraKlijenta" +
           " JOIN usluga ON termin.sifraUsluge = usluga.sifraUsluge";
}


@Override
public List<AbstractDomainObject> getList(ResultSet rs) {
    List<AbstractDomainObject> termini = new ArrayList<>();
    try {
        while (rs.next()) {
            // Termin
            Termin termin = new Termin();
            termin.setDatumVremeTermina(rs.getTimestamp("datumVremeTermina"));
            termin.setBrojProstorije(rs.getInt("brojProstorije"));
            termin.setNapomena(rs.getString("napomena"));
            termin.setKonacnaCena(rs.getDouble("konacnaCena"));
            termin.setVaucer(Vaucer.valueOf(rs.getString("vaucer")));

            // Klijent
            Klijent klijent = new Klijent();
            klijent.setSifraKlijenta(rs.getLong("sifraKlijenta"));
            klijent.setIme(rs.getString("ime"));
            klijent.setPrezime(rs.getString("prezime"));
            klijent.setStarost(rs.getInt("starost"));
            klijent.setBrojTelefona(rs.getString("brojTelefona"));
            klijent.setEmail(rs.getString("email"));
            // Možeš dodati i postavljanje TipKlijenta ako je potrebno

            termin.setKlijent(klijent);

            // Usluga
            Usluga usluga = new Usluga();
            usluga.setSifraUsluge(rs.getLong("sifraUsluge"));
            usluga.setNazivUsluge(rs.getString("nazivUsluge"));
            usluga.setCenaUsluge(rs.getDouble("cenaUsluge"));
            usluga.setTrajanjeUsluge(rs.getInt("trajanjeUsluge"));
            // Možeš dodati i postavljanje VrstaUsluge ako je potrebno

            termin.setUsluga(usluga);

            termini.add(termin);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return termini;
}


    @Override
    public void setAutoIncrementPrimaryKey(long generatedKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
public String conditon() {
    return "datumVremeTermina";
}

 @Override
    public Object setCondition() {
        return this.datumVremeTermina; // Return the actual condition value
    }

    @Override
    public AbstractDomainObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
