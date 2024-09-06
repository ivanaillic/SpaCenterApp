package so.usluga;

import domain.AbstractDomainObject;
import domain.NapomenaZaUslugu;
import domain.Usluga;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOAddUsluga extends AbstractSO {

    private Usluga usluga;

    public SOAddUsluga() throws Exception {
        super();
    }

    public Usluga getUsluga() {
        return usluga;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        usluga = (Usluga) databaseBroker.add(object);

        List<NapomenaZaUslugu> napomene = usluga.getNapomene();
        if (napomene != null && !napomene.isEmpty()) {
            for (NapomenaZaUslugu napomena : napomene) {
                napomena.setUsluga(usluga);
                databaseBroker.add(napomena);
            }
        }
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        usluga = (Usluga) object;
        if (!(object instanceof Usluga)) {
            throw new Exception("Object is not valid!");
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
