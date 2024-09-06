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
public class Usluga extends AbstractDomainObject implements Serializable {

    private Long sifraUsluge;
    private String nazivUsluge;
    private double cenaUsluge;
    private int trajanjeUsluge;
    private VrstaUsluge vrstaUsluge;
    private List<NapomenaZaUslugu> napomene;

    public Usluga() {
        this.napomene = new ArrayList<>();
    }

    public Usluga(Long sifraUsluge, String nazivUsluge, double cenaUsluge, int trajanjeUsluge, VrstaUsluge vrstaUsluge, List<NapomenaZaUslugu> napomene) {
        this.sifraUsluge = sifraUsluge;
        this.nazivUsluge = nazivUsluge;
        this.cenaUsluge = cenaUsluge;
        this.trajanjeUsluge = trajanjeUsluge;
        this.vrstaUsluge = vrstaUsluge;
        this.napomene = napomene != null ? napomene : new ArrayList<>();
    }

    public Usluga(Long sifraUsluge, String nazivUsluge, double cenaUsluge, int trajanjeUsluge, VrstaUsluge vrstaUsluge) {
        this.sifraUsluge = sifraUsluge;
        this.nazivUsluge = nazivUsluge;
        this.cenaUsluge = cenaUsluge;
        this.trajanjeUsluge = trajanjeUsluge;
        this.vrstaUsluge = vrstaUsluge;
    }

    public List<NapomenaZaUslugu> getNapomene() {
        return napomene;
    }

    public void setNapomene(List<NapomenaZaUslugu> napomene) {
        this.napomene = napomene;
    }

    public Long getSifraUsluge() {
        return sifraUsluge;
    }

    public void setSifraUsluge(Long sifraUsluge) {
        this.sifraUsluge = sifraUsluge;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public void setNazivUsluge(String nazivUsluge) {
        this.nazivUsluge = nazivUsluge;
    }

    public double getCenaUsluge() {
        return cenaUsluge;
    }

    public void setCenaUsluge(double cenaUsluge) {
        this.cenaUsluge = cenaUsluge;
    }

    public int getTrajanjeUsluge() {
        return trajanjeUsluge;
    }

    public void setTrajanjeUsluge(int trajanjeUsluge) {
        this.trajanjeUsluge = trajanjeUsluge;
    }

    public VrstaUsluge getVrstaUsluge() {
        return vrstaUsluge;
    }

    public void setVrstaUsluge(VrstaUsluge vrstaUsluge) {
        this.vrstaUsluge = vrstaUsluge;
    }

//    @Override
//    public String toString() {
//        return "Usluga{"
//                + "sifraUsluge=" + sifraUsluge
//                + ", nazivUsluge='" + nazivUsluge + '\''
//                + ", cenaUsluge=" + cenaUsluge
//                + ", trajanjeUsluge=" + trajanjeUsluge
//                + ", vrstaUsluge=" + (vrstaUsluge != null ? vrstaUsluge.getNazivVrsteUsluge() : "null")
//                + ", napomene=" + napomene.size()
//                + '}';
//    }

    @Override
    public String toString() {
        return nazivUsluge;
    }
    
    

    @Override
    public int hashCode() {
        return Objects.hash(sifraUsluge, nazivUsluge, cenaUsluge, trajanjeUsluge, vrstaUsluge, napomene);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usluga usluga = (Usluga) obj;
        return Double.compare(usluga.cenaUsluge, cenaUsluge) == 0
                && trajanjeUsluge == usluga.trajanjeUsluge
                && Objects.equals(sifraUsluge, usluga.sifraUsluge)
                && Objects.equals(nazivUsluge, usluga.nazivUsluge)
                && Objects.equals(vrstaUsluge, usluga.vrstaUsluge)
                && Objects.equals(napomene, usluga.napomene);
    }

    @Override
    public String getTableName() {
        return "usluga";
    }

    @Override
    public String getColumnsForInsert() {
        return "(nazivUsluge, cenaUsluge, trajanjeUsluge, sifraVrsteUsluge)";
    }

    @Override
    public String getParamsForInsert() {
        return "(?, ?, ?, ?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        Usluga usluga = (Usluga) domainObject;

        try {
            statement.setString(1, usluga.getNazivUsluge());
            statement.setDouble(2, usluga.getCenaUsluge());
            statement.setInt(3, usluga.getTrajanjeUsluge());
            statement.setLong(4, vrstaUsluge.getSifraVrsteUsluge());

            System.out.println("Inserting Usluga: " + usluga.toString());
        } catch (SQLException e) {
            System.err.println("Error setting params for insert: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public String getColumnsForUpdate() {
        return " nazivUsluge = ?, cenaUsluge = ?, trajanjeUsluge = ?, sifraVrsteUsluge = ?";
    }

    @Override
    public String getParamsForUpdate() {
        return " SET nazivUsluge = ?, cenaUsluge = ?, trajanjeUsluge = ?, sifraVrsteUsluge = ?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException {
        Usluga usluga = (Usluga) domainObject;

        statement.setString(1, usluga.getNazivUsluge());
        statement.setDouble(2, usluga.getCenaUsluge());
        statement.setInt(3, usluga.getTrajanjeUsluge());
        statement.setLong(4, usluga.getVrstaUsluge().getSifraVrsteUsluge());
        statement.setLong(5, usluga.getSifraUsluge());
    }

    @Override
    public String getPrimaryKey() {
        return "sifraUsluge";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return sifraUsluge;
    }

    @Override
    public void setAutoIncrementPrimaryKey(long generatedKey) {
        setSifraUsluge(generatedKey);
    }

    @Override
    public String alias() {
        return "u";
    }

    @Override
    public String join() {
        return " u JOIN vrstausluge vu ON u.sifraVrsteUsluge = vu.sifraVrsteUsluge";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) {
        List<AbstractDomainObject> resultList = new ArrayList<>();
        try {
            while (rs.next()) {
                Long sifraUsluge = rs.getLong("sifraUsluge");
                String nazivUsluge = rs.getString("nazivUsluge");
                double cenaUsluge = rs.getDouble("cenaUsluge");
                int trajanjeUsluge = rs.getInt("trajanjeUsluge");

                Long sifraVrsteUsluge = rs.getLong("sifraVrsteUsluge");
                String nazivVrsteUsluge = rs.getString("nazivVrsteUsluge");
                VrstaUsluge vrstaUsluge = new VrstaUsluge(sifraVrsteUsluge, nazivVrsteUsluge);

                Usluga usluga = new Usluga(sifraUsluge, nazivUsluge, cenaUsluge, trajanjeUsluge, vrstaUsluge, new ArrayList<>());

                resultList.add(usluga);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public String setCondition() {
        return nazivUsluge;
    }

    @Override
    public String conditon() {
        return "nazivUsluge";

    }

    @Override
    public AbstractDomainObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
