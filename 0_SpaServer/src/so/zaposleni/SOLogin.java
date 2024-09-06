package so.zaposleni;

import domain.AbstractDomainObject;
import domain.Zaposleni;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOLogin extends AbstractSO {

    private Zaposleni zaposleni;

    public SOLogin(Zaposleni zaposleni) throws Exception {
        super();
        this.zaposleni = zaposleni;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        if (databaseBroker == null) {
            throw new Exception("Database broker is not initialized.");
        }

        if (!(object instanceof Zaposleni)) {
            throw new Exception("Object is not valid.");
        }

        Zaposleni temp = (Zaposleni) object;
        zaposleni = (Zaposleni) databaseBroker.getObjectByCondition(temp, "korisnickoIme = ? AND lozinka = ?", temp.getKorisnickoIme(), temp.getLozinka());
        if (zaposleni == null) {
            throw new Exception("User does not exist. Korisničko ime: " + temp.getKorisnickoIme());
        }
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        if (!(object instanceof Zaposleni)) {
            throw new Exception("Object is not valid");
        }
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }
}
