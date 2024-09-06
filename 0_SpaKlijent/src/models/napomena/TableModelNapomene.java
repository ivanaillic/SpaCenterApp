package models.napomena;

import domain.NapomenaZaUslugu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivana
 */
public class TableModelNapomene extends AbstractTableModel {

    private String[] kolone = { "Opis napomene", "Tip napomene"};
    private List<NapomenaZaUslugu> lista;

   public TableModelNapomene(List<NapomenaZaUslugu> lista) {
    if (lista != null) {
        this.lista = lista;
    } else {
        this.lista = new ArrayList<>(); 
    }
}

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NapomenaZaUslugu napomena = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return napomena.getOpisNapomene();
            case 1:
                return napomena.getTipNapomene().getNazivTipaNapomene();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<NapomenaZaUslugu> getLista() {
        return lista;
    }

    
  
}
