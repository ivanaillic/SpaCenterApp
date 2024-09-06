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
public class TipKlijenta extends AbstractDomainObject implements Serializable {

    private Long sifraTipaKlijenta;
    private String nazivTipaKlijenta;

    public TipKlijenta() {
    }

    public TipKlijenta(Long sifraTipaKlijenta, String nazivTipaKlijenta) {
        this.sifraTipaKlijenta = sifraTipaKlijenta;
        this.nazivTipaKlijenta = nazivTipaKlijenta;
    }

    public Long getSifraTipaKlijenta() {
        return sifraTipaKlijenta;
    }

    public void setSifraTipaKlijenta(Long sifraTipaKlijenta) {
        this.sifraTipaKlijenta = sifraTipaKlijenta;
    }

    public String getNazivTipaKlijenta() {
        return nazivTipaKlijenta;
    }

    public void setNazivTipaKlijenta(String nazivTipaKlijenta) {
        this.nazivTipaKlijenta = nazivTipaKlijenta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.sifraTipaKlijenta);
        hash = 29 * hash + Objects.hashCode(this.nazivTipaKlijenta);
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
        final TipKlijenta other = (TipKlijenta) obj;
        if (!Objects.equals(this.nazivTipaKlijenta, other.nazivTipaKlijenta)) {
            return false;
        }
        return Objects.equals(this.sifraTipaKlijenta, other.sifraTipaKlijenta);
    }

    @Override
    public String toString() {
        return nazivTipaKlijenta;
    }

    @Override
    public String getTableName() {
        return "tipklijenta";
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
                TipKlijenta tipKlijenta = new TipKlijenta();
                tipKlijenta.setSifraTipaKlijenta(rs.getLong("sifraTipaKlijenta"));
                tipKlijenta.setNazivTipaKlijenta(rs.getString("nazivTipaKlijenta"));
                resultList.add(tipKlijenta);
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

    @Override
    public String setCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AbstractDomainObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
  

  
}
