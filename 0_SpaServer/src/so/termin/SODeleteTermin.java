package so.termin;

import domain.AbstractDomainObject;
import domain.Termin;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SODeleteTermin extends AbstractSO {

    public SODeleteTermin() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        Termin termin = (Termin) object;

        
        databaseBroker.delete(termin);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        if (!(object instanceof Termin)) {
            throw new IllegalArgumentException("Argument must be of type Termin.");
        }
    }

}
