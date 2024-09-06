package so.usluga;

import domain.AbstractDomainObject;
import domain.NapomenaZaUslugu;
import domain.Usluga;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;
/**
 *
 * @author Ivana
 */
public class SOUpdateUsluga extends AbstractSO {

    public SOUpdateUsluga() throws Exception {
        super();
    }

    private Usluga usluga;

    public Usluga getUsluga() {
        return usluga;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        usluga = (Usluga) object;

        databaseBroker.update(usluga);

        List<NapomenaZaUslugu> napomeneZaBrisanje = new ArrayList<>();
        List<NapomenaZaUslugu> napomeneZaDodavanje = new ArrayList<>();

        NapomenaZaUslugu napomenaZaUsluguSablon = new NapomenaZaUslugu();
        napomenaZaUsluguSablon.setUsluga(usluga);
        List<AbstractDomainObject> postojeceNapomeneAbstraktno = databaseBroker.getAllConditon(napomenaZaUsluguSablon);
        List<NapomenaZaUslugu> postojeceNapomene = new ArrayList<>();
        for (AbstractDomainObject apstraktnaNapomena : postojeceNapomeneAbstraktno) {
            postojeceNapomene.add((NapomenaZaUslugu) apstraktnaNapomena);
        }

        for (NapomenaZaUslugu postojecaNapomena : postojeceNapomene) {
            if (!usluga.getNapomene().contains(postojecaNapomena)) {
                napomeneZaBrisanje.add(postojecaNapomena);
            }
        }

        for (NapomenaZaUslugu novaNapomena : usluga.getNapomene()) {
            if (novaNapomena.getRedniBroj() == null) {
                napomeneZaDodavanje.add(novaNapomena);
            }
        }

        for (NapomenaZaUslugu napomena : napomeneZaBrisanje) {
            databaseBroker.delete(napomena);
        }

        for (NapomenaZaUslugu napomena : napomeneZaDodavanje) {
            napomena.setUsluga(usluga); 
            databaseBroker.add(napomena);
        }
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        Usluga usluga = (Usluga) object;

        if (!(object instanceof Usluga)) {
            throw new Exception("Object is not a valid Usluga!");
        }
        if (usluga.getNazivUsluge() == null || usluga.getNazivUsluge().isEmpty()) {
            throw new Exception("Naziv usluge mora biti unet");
        }
        if (usluga.getCenaUsluge() <= 0) {
            throw new Exception("Cena usluge mora biti veca od nule");
        }
        if (usluga.getTrajanjeUsluge() <= 0) {
            throw new Exception("Trajanje usluge mora biti vece od nule");
        }
        if (usluga.getVrstaUsluge() == null) {
            throw new Exception("Vrsta usluge mora biti oznacena");
        }

       
    }
}
