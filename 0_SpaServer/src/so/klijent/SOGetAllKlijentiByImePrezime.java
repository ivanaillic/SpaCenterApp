package so.klijent;

import domain.AbstractDomainObject;
import domain.Klijent;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetAllKlijentiByImePrezime extends AbstractSO {

    private List<AbstractDomainObject> filteredKlijenti;
    private String imePrezime;

    public SOGetAllKlijentiByImePrezime(String imePrezime) throws Exception {
        super();
        this.imePrezime = imePrezime;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        String ime = "";
        String prezime = "";

        if (imePrezime.contains(" ")) {
            String[] parts = imePrezime.split(" ");
            if (parts.length >= 2) {
                ime = parts[0];
                prezime = parts[1];
            }
        } else {
            ime = imePrezime;
            prezime = imePrezime;
        }


        SOGetAllKlijenti allKlijenti = new SOGetAllKlijenti();
        allKlijenti.execute(new Klijent());
        List<AbstractDomainObject> klijenti = allKlijenti.getKlijenti();

        List<AbstractDomainObject> filteredKlijenti = new ArrayList<>();
        for (AbstractDomainObject klijent : klijenti) {
            if ((ime.isEmpty() || ((Klijent) klijent).getIme().contains(ime))
                    && (prezime.isEmpty() || ((Klijent) klijent).getPrezime().contains(prezime))) {
                filteredKlijenti.add(klijent);
            }
        }
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        
    }

    public List<AbstractDomainObject> getFilteredKlijenti() {
        return filteredKlijenti;
    }
}
