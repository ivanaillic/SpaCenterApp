/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.usluga;

import domain.Usluga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivana
 */
public class TableModelUsluge extends AbstractTableModel {

    private List<Usluga> usluge;
    private final String[] columnNames = {"Naziv", "Cena", "Trajanje", "Vrsta"};

    public TableModelUsluge(List<Usluga> usluge) {
        this.usluge = usluge;
    }

    @Override
    public int getRowCount() {
        return usluge.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usluga usluga = usluge.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usluga.getNazivUsluge();
            case 1:
                return usluga.getCenaUsluge();
            case 2:
                return usluga.getTrajanjeUsluge();
            case 3:
                return usluga.getVrstaUsluge().getNazivVrsteUsluge();
            default:
                return null;
        }
    }

    public List<Usluga> getUsluge() {
        return usluge;
    }

    public void setUsluge(List<Usluga> usluge) {
        this.usluge = usluge;
    }

    public Usluga vratiNaOsnovuReda(int red) {
        return usluge.get(red);
    }
}
