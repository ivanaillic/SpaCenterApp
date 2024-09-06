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
public class TipNapomeneZaUslugu extends AbstractDomainObject implements Serializable {

    private Long sifraTipaNapomene;
    private String nazivTipaNapomene;

    public TipNapomeneZaUslugu() {
    }

    public TipNapomeneZaUslugu(Long sifraTipaNapomene, String nazivTipaNapomene) {
        this.sifraTipaNapomene = sifraTipaNapomene;
        this.nazivTipaNapomene = nazivTipaNapomene;
    }

    public Long getSifraTipaNapomene() {
        return sifraTipaNapomene;
    }

    public void setSifraTipaNapomene(Long sifraTipaNapomene) {
        this.sifraTipaNapomene = sifraTipaNapomene;
    }

    public String getNazivTipaNapomene() {
        return nazivTipaNapomene;
    }

    public void setNazivTipaNapomene(String nazivTipaNapomene) {
        this.nazivTipaNapomene = nazivTipaNapomene;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.sifraTipaNapomene);
        hash = 19 * hash + Objects.hashCode(this.nazivTipaNapomene);
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
        final TipNapomeneZaUslugu other = (TipNapomeneZaUslugu) obj;
        if (!Objects.equals(this.nazivTipaNapomene, other.nazivTipaNapomene)) {
            return false;
        }
        return Objects.equals(this.sifraTipaNapomene, other.sifraTipaNapomene);
    }

    @Override
    public String toString() {
        return nazivTipaNapomene;
    }

    @Override
    public String getTableName() {
        return "tipnapomenezauslugu";
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
                TipNapomeneZaUslugu tipNapomene = new TipNapomeneZaUslugu(); // Promenjeno ime objekta
                tipNapomene.setSifraTipaNapomene(rs.getLong("sifraTipaNapomene")); // Promenjen naziv kolone
                tipNapomene.setNazivTipaNapomene(rs.getString("nazivTipaNapomene")); // Promenjen naziv kolone
                resultList.add(tipNapomene);
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
