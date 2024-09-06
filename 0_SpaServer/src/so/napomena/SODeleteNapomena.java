/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.napomena;

import domain.AbstractDomainObject;
import domain.NapomenaZaUslugu;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SODeleteNapomena extends AbstractSO {

    public SODeleteNapomena() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        databaseBroker.delete(object);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
 if (!(object instanceof NapomenaZaUslugu)) {
        throw new IllegalArgumentException("Argument must be of type NapomenaZaUslugu.");
    }
    }

}
