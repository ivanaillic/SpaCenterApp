/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.termini;

import domain.Termin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivana
 */
public class TableModelTermini extends AbstractTableModel {

    private List<Termin> termini;
    private final String[] columnNames = {"Klijent", "Usluga", "Datum i vreme", "Broj prostorije", "Napomena", "Vaucer", "Konacna cena"};

    public TableModelTermini() {
        termini = new ArrayList<>();
    }

    public TableModelTermini(List<Termin> termini) {
        this.termini = termini;
    }
    
    

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
        fireTableDataChanged();
    }

    public List<Termin> getTermini() {
        return termini;
    }

    @Override
    public int getRowCount() {
        return termini.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Termin termin = termini.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return termin.getKlijent();
            case 1:
                return termin.getUsluga();
            case 2:
                return termin.getDatumVremeTermina();
            case 3:
                return termin.getBrojProstorije();
            case 4:
                return termin.getNapomena();
            case 5:
                return termin.getVaucer();
            case 6:
                return termin.getKonacnaCena();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

     public Termin vratiNaOsnovuReda(int rowIndex) {
        return termini.get(rowIndex);
    }
}
