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
public class VrstaUsluge extends AbstractDomainObject implements Serializable {

    private Long sifraVrsteUsluge;
    private String nazivVrsteUsluge;

    public VrstaUsluge() {
    }

    public VrstaUsluge(Long sifraVrsteUsluge, String nazivVrsteUsluge) {
        this.sifraVrsteUsluge = sifraVrsteUsluge;
        this.nazivVrsteUsluge = nazivVrsteUsluge;
    }

    public Long getSifraVrsteUsluge() {
        return sifraVrsteUsluge;
    }

    public void setSifraVrsteUsluge(Long sifraVrsteUsluge) {
        this.sifraVrsteUsluge = sifraVrsteUsluge;
    }

    public String getNazivVrsteUsluge() {
        return nazivVrsteUsluge;
    }

    public void setNazivVrsteUsluge(String nazivVrsteUsluge) {
        this.nazivVrsteUsluge = nazivVrsteUsluge;
    }

    @Override
    public String toString() {
        return nazivVrsteUsluge;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.sifraVrsteUsluge);
        hash = 47 * hash + Objects.hashCode(this.nazivVrsteUsluge);
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
        final VrstaUsluge other = (VrstaUsluge) obj;
        if (!Objects.equals(this.nazivVrsteUsluge, other.nazivVrsteUsluge)) {
            return false;
        }
        return Objects.equals(this.sifraVrsteUsluge, other.sifraVrsteUsluge);
    }

    @Override
    public String getTableName() {
        return "vrstausluge";
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long getPrimaryKeyValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String alias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) {
        List<AbstractDomainObject> resultList = new ArrayList<>();

        try {
            while (rs.next()) {
                VrstaUsluge vrstaUsluge = new VrstaUsluge();
                vrstaUsluge.setSifraVrsteUsluge(rs.getLong("sifraVrsteUsluge"));
                vrstaUsluge.setNazivVrsteUsluge(rs.getString("nazivVrsteUsluge"));
                resultList.add(vrstaUsluge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public String getPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAutoIncrementPrimaryKey(long generatedKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public String conditon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

  

    public String toLowerCase() {
        if (nazivVrsteUsluge != null) {
            return nazivVrsteUsluge.toLowerCase();
        } else {
            return null;
        }
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
