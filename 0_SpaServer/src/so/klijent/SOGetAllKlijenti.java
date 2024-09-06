/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klijent;

import domain.AbstractDomainObject;
import domain.Klijent;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetAllKlijenti extends AbstractSO {

    public SOGetAllKlijenti() throws Exception {
        super();
    }
    private List<AbstractDomainObject> klijenti;

    public List<AbstractDomainObject> getKlijenti() {
        return klijenti;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        klijenti = databaseBroker.getAll(object);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
    }

}
