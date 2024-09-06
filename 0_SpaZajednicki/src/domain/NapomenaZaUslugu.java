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
public class NapomenaZaUslugu extends AbstractDomainObject implements Serializable {

    private Usluga usluga;
    private Long redniBroj;
    private String opisNapomene;
    private TipNapomeneZaUslugu tipNapomene;

    public NapomenaZaUslugu() {
    }

    public NapomenaZaUslugu(Usluga usluga, Long redniBroj, String opisNapomene, TipNapomeneZaUslugu tipNapomene) {
        this.usluga = usluga;
        this.redniBroj = redniBroj;
        this.opisNapomene = opisNapomene;
        this.tipNapomene = tipNapomene;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Long getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(Long redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getOpisNapomene() {
        return opisNapomene;
    }

    public void setOpisNapomene(String opisNapomene) {
        this.opisNapomene = opisNapomene;
    }

    public TipNapomeneZaUslugu getTipNapomene() {
        return tipNapomene;
    }

    public void setTipNapomene(TipNapomeneZaUslugu tipNapomene) {
        this.tipNapomene = tipNapomene;
    }

   @Override
public String toString() {
    return "NapomenaZaUslugu{" +
            "redniBroj=" + redniBroj +
            ", opisNapomene='" + opisNapomene + '\'' +
            ", tipNapomene=" + tipNapomene.getNazivTipaNapomene() + 
            '}';
}


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.usluga);
        hash = 37 * hash + Objects.hashCode(this.redniBroj);
        hash = 37 * hash + Objects.hashCode(this.opisNapomene);
        hash = 37 * hash + Objects.hashCode(this.tipNapomene);
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
        final NapomenaZaUslugu other = (NapomenaZaUslugu) obj;
        if (!Objects.equals(this.opisNapomene, other.opisNapomene)) {
            return false;
        }
        if (!Objects.equals(this.usluga, other.usluga)) {
            return false;
        }
        if (!Objects.equals(this.redniBroj, other.redniBroj)) {
            return false;
        }
        return Objects.equals(this.tipNapomene, other.tipNapomene);
    }

    @Override
    public String getTableName() {
        return " napomenazauslugu";
    }

    @Override
    public String getColumnsForInsert() {
        return " (sifraUsluge, redniBroj, opisNapomene, sifraTipaNapomene)";
    }

    @Override
    public String getParamsForInsert() {
        return " (?, ?, ?, ?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        NapomenaZaUslugu napomena = (NapomenaZaUslugu) domainObject;

        try {
            statement.setLong(1, napomena.getUsluga().getSifraUsluge());
            // Provera null vrednosti za redniBroj pre pristupa metodi
            if (napomena.getRedniBroj() != null) {
                statement.setLong(2, napomena.getRedniBroj());
            } else {
                statement.setNull(2, java.sql.Types.BIGINT);
            }
            statement.setString(3, napomena.getOpisNapomene());
            statement.setLong(4, napomena.getTipNapomene().getSifraTipaNapomene());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException in setParamsForInsert for NapomenaZaUslugu: " + e.getMessage());
            e.printStackTrace();
            throw e; // Bacanje izuzetka dalje kako bi se znalo da je došlo do greške
        }
    }

    @Override
    public String getColumnsForUpdate() {
        return " sifraUsluge = ?, redniBroj = ?, opisNapomene = ?, sifraTipaNapomene = ?";
    }

    @Override
    public String getParamsForUpdate() {
        return " SET sifraUsluge = ?, redniBroj = ?, opisNapomene = ?, sifraTipaNapomene = ?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        NapomenaZaUslugu napomena = (NapomenaZaUslugu) domainObject;
        statement.setLong(1, napomena.getUsluga().getSifraUsluge());
        statement.setLong(2, napomena.getRedniBroj());
        statement.setString(3, napomena.getOpisNapomene());
        statement.setLong(4, napomena.getTipNapomene().getSifraTipaNapomene());
    }

    @Override
    public String alias() {
        return "n";
    }

    @Override
    public String join() {
        return " n JOIN usluga u ON n.sifraUsluge = u.sifraUsluge "
                + " JOIN tipnapomenezauslugu tnu ON n.sifraTipaNapomene = tnu.sifraTipaNapomene ";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) {
        List<AbstractDomainObject> resultList = new ArrayList<>();

        try {
            while (rs.next()) {
                Usluga usluga = new Usluga();
                usluga.setSifraUsluge(rs.getLong("sifraUsluge"));
                usluga.setNazivUsluge(rs.getString("nazivUsluge"));
                usluga.setCenaUsluge(rs.getDouble("cenaUsluge"));
                usluga.setTrajanjeUsluge(rs.getInt("trajanjeUsluge"));

                VrstaUsluge vrstaUsluge = new VrstaUsluge();
                vrstaUsluge.setSifraVrsteUsluge(rs.getLong("sifraVrsteUsluge"));
                usluga.setVrstaUsluge(vrstaUsluge);

                Long redniBroj = rs.getLong("redniBroj");
                String opisNapomene = rs.getString("opisNapomene");

                TipNapomeneZaUslugu tipNapomene = new TipNapomeneZaUslugu();
                tipNapomene.setSifraTipaNapomene(rs.getLong("sifraTipaNapomene"));
                tipNapomene.setNazivTipaNapomene(rs.getString("nazivTipaNapomene"));

                NapomenaZaUslugu napomena = new NapomenaZaUslugu(usluga, redniBroj, opisNapomene, tipNapomene);
                resultList.add(napomena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public String getPrimaryKey() {
        return "redniBroj";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return redniBroj;
    }

    @Override
    public void setAutoIncrementPrimaryKey(long generatedKey) {
        setRedniBroj(generatedKey);
    }

    @Override
    public String conditon() {
        return "n.sifraUsluge";
    }

    @Override
    public Object setCondition() {
        return usluga.getSifraUsluge();
    }

    @Override
    public AbstractDomainObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }





}
