/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.termin;

import domain.AbstractDomainObject;
import domain.Termin;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOAddTermin extends AbstractSO {

    public SOAddTermin() throws Exception {
        super();
    }

    
    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        Termin termin = (Termin) object;

        databaseBroker.add(termin);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        if (!(object instanceof Termin)) {
            throw new IllegalArgumentException("Objekat nije tipa Termin.");
        }
    }

}
