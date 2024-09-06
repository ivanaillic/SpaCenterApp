/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ivana
 */
public class Zaposleni extends AbstractDomainObject implements Serializable {

    private Long sifraZaposlenog;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Zaposleni() {
    }

    public Zaposleni(Long sifraZaposlenog, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.sifraZaposlenog = sifraZaposlenog;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Long getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(Long sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.sifraZaposlenog);
        hash = 13 * hash + Objects.hashCode(this.ime);
        hash = 13 * hash + Objects.hashCode(this.prezime);
        hash = 13 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 13 * hash + Objects.hashCode(this.lozinka);
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
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        return Objects.equals(this.sifraZaposlenog, other.sifraZaposlenog);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "zaposleni";
    }

    @Override
    public String getColumnsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        Zaposleni z = new Zaposleni();
        statement.setString(1, korisnickoIme);
        statement.setString(2, lozinka);
    }

    @Override
    public Long getPrimaryKeyValue() {
        return sifraZaposlenog;
    }

    @Override
    public String alias() {
        return "z";
    }

    @Override
    public String join() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPrimaryKey() {
        return "z.sifraZaposlenog";
    }

    @Override
    public void setAutoIncrementPrimaryKey(long generatedKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String conditon() {
        return "WHERE z.korisnickoIme=? AND z.lozinka=?";
    }

    @Override
    public String setCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Zaposleni getObject(ResultSet rs) throws SQLException {
        Zaposleni zaposleni = new Zaposleni();
        zaposleni.setSifraZaposlenog(rs.getLong("sifraZaposlenog"));
        zaposleni.setIme(rs.getString("ime"));
        zaposleni.setPrezime(rs.getString("prezime"));
        zaposleni.setKorisnickoIme(rs.getString("korisnickoIme"));
        zaposleni.setLozinka(rs.getString("lozinka"));
        return zaposleni;
    }

}
