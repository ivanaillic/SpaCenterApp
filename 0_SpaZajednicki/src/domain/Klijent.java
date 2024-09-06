/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
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
public class Klijent extends AbstractDomainObject implements Serializable {

    private Long sifraKlijenta;
    private String ime;
    private String prezime;
    private int starost;
    private String brojTelefona;
    private String email;
    private TipKlijenta tipKlijenta;

    public Klijent() {
    }

    public Klijent(Long sifraKlijenta, String ime, String prezime, int starost, String brojTelefona, String email, TipKlijenta tipKlijenta) {
        this.sifraKlijenta = sifraKlijenta;
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.tipKlijenta = tipKlijenta;
    }

    public Long getSifraKlijenta() {
        return sifraKlijenta;
    }

    public void setSifraKlijenta(Long sifraKlijenta) {
        this.sifraKlijenta = sifraKlijenta;
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

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public TipKlijenta getTipKlijenta() {
        return tipKlijenta;
    }

    public void setTipKlijenta(TipKlijenta tipKlijenta) {
        this.tipKlijenta = tipKlijenta;
    }


    @Override
    public String toString() {
        return ime+ " "+prezime;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.sifraKlijenta);
        hash = 97 * hash + Objects.hashCode(this.ime);
        hash = 97 * hash + Objects.hashCode(this.prezime);
        hash = 97 * hash + this.starost;
        hash = 97 * hash + Objects.hashCode(this.brojTelefona);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.tipKlijenta);
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
        final Klijent other = (Klijent) obj;
        if (this.starost != other.starost) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.sifraKlijenta, other.sifraKlijenta)) {
            return false;
        }
        return Objects.equals(this.tipKlijenta, other.tipKlijenta);
    }

    @Override
    public String getTableName() {
        return "klijent ";
    }

    @Override
    public String getColumnsForInsert() {
        return "(ime, prezime, starost, brojTelefona, email, sifraTipaKlijenta)";
    }

    @Override
    public String getParamsForInsert() {
        return "(?, ?, ?, ?, ?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        Klijent klijent = (Klijent) domainObject;
        statement.setString(1, klijent.getIme());
        statement.setString(2, klijent.getPrezime());
        statement.setInt(3, klijent.getStarost());
        statement.setString(4, klijent.getBrojTelefona());
        statement.setString(5, klijent.getEmail());
        statement.setLong(6, klijent.getTipKlijenta().getSifraTipaKlijenta());
    }

    @Override
    public String getColumnsForUpdate() {
        return "prezime=?, starost=?, brojTelefona=?, email=?, sifraTipaKlijenta=?";
    }

    @Override
    public String getParamsForUpdate() {
        return "SET prezime=?, starost=?, brojTelefona=?, email=?, sifraTipaKlijenta=?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        Klijent klijent = (Klijent) domainObject;
        statement.setString(1, klijent.getPrezime());
        statement.setInt(2, klijent.getStarost());
        statement.setString(3, klijent.getBrojTelefona());
        statement.setString(4, klijent.getEmail());
        statement.setLong(5, klijent.getTipKlijenta().getSifraTipaKlijenta()); 
        statement.setLong(6, klijent.getSifraKlijenta()); 
    }

    @Override
    public Long getPrimaryKeyValue() {
        return sifraKlijenta;
    }

    @Override
    public String alias() {
        return "k ";
    }

    @Override
    public String join() {
        return " k JOIN tipklijenta tk ON k.sifraTipaKlijenta = tk.sifraTipaKlijenta";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) {
        List<AbstractDomainObject> resultList = new ArrayList<>();

        try {
            while (rs.next()) {
                Klijent klijent = new Klijent();
                klijent.setSifraKlijenta(rs.getLong("k.sifraKlijenta"));
                klijent.setIme(rs.getString("k.ime"));
                klijent.setPrezime(rs.getString("k.prezime"));
                klijent.setStarost(rs.getInt("k.starost"));
                klijent.setBrojTelefona(rs.getString("k.brojTelefona"));
                klijent.setEmail(rs.getString("k.email"));

                TipKlijenta tipKlijenta = new TipKlijenta();
                tipKlijenta.setSifraTipaKlijenta(rs.getLong("tk.sifraTipaKlijenta"));
                tipKlijenta.setNazivTipaKlijenta(rs.getString("tk.nazivTipaKlijenta"));
                klijent.setTipKlijenta(tipKlijenta);

                resultList.add(klijent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public String getPrimaryKey() {
        return "sifraKlijenta";
    }

    @Override
    public void setAutoIncrementPrimaryKey(long generatedKey) {
        setSifraKlijenta(sifraKlijenta);
    }

    @Override
    public String conditon() {
        return "WHERE sifraKlijenta = ?";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String setCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AbstractDomainObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

}
