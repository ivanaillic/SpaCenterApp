/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.usluga;

import domain.AbstractDomainObject;
import domain.NapomenaZaUslugu;
import domain.Usluga;
import java.util.List;
import so.AbstractSO;
import so.napomena.SODeleteNapomena;
import so.napomena.SOGetNapomena;

/**
 *
 * @author Ivana
 */
public class SODeleteUsluga extends AbstractSO {

    public SODeleteUsluga() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        Usluga usluga = (Usluga) object;

        SOGetNapomena getSveNapomene = new SOGetNapomena();
        getSveNapomene.execute(usluga);
        List<AbstractDomainObject> napomene = getSveNapomene.getUsluge();

        if (napomene != null && !napomene.isEmpty()) {
            for (AbstractDomainObject abstractDomainObject : napomene) {
                if (abstractDomainObject instanceof NapomenaZaUslugu) {
                    NapomenaZaUslugu napomena = (NapomenaZaUslugu) abstractDomainObject;
                    SODeleteNapomena deleteNapomena = new SODeleteNapomena();
                    deleteNapomena.execute(napomena);
                } else {
                    
                }
            }
        }

        databaseBroker.delete(usluga);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        if (!(object instanceof Usluga)) {
            throw new IllegalArgumentException("Argument must be of type Usluga.");
        }
    }

}
