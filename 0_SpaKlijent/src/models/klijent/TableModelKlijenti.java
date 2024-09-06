package models.klijent;

import domain.Klijent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivana
 */
public class TableModelKlijenti extends AbstractTableModel {

    private String[] kolone = {"Sifra klijenta", "Ime", "Prezime", "Starost", "Broj telefona", "Email", "Tip klijenta"};
    private List<Klijent> lista= new ArrayList<>();

    public TableModelKlijenti(List<Klijent> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("Lista klijenata ne sme biti null.");
        }
        this.lista = lista;
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
        Klijent k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getSifraKlijenta();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getStarost();
            case 4:
                return k.getBrojTelefona();
            case 5:
                return k.getEmail();
            case 6:
                return k.getTipKlijenta().getNazivTipaKlijenta();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Klijent vratiNaOsnovuReda(int red) {
        return lista.get(red);
    }
}
