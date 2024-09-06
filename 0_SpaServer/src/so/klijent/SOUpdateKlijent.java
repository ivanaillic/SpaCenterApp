/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klijent;

import domain.AbstractDomainObject;
import domain.Klijent;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOUpdateKlijent extends AbstractSO {

    public SOUpdateKlijent() throws Exception {
        super();
    }
    private Klijent klijent;

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        databaseBroker.update((Klijent) object);

    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        klijent = (Klijent) object;
        if (!(object instanceof Klijent)) {
            throw new Exception("Object is not valid!");
        }
        if (klijent.getIme().isEmpty()) {
            throw new Exception("Field name must not be empty!");
        }
        if (klijent.getPrezime().isEmpty()) {
            throw new Exception("Field surname must not be empty!");
        }
        if (klijent.getStarost() <= 0) {
            throw new Exception("Age must be a positive number!");
        }
        if (klijent.getEmail().isEmpty()) {
            throw new Exception("Email must not be empty!");
        }

    }

}
