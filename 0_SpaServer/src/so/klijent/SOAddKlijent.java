/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klijent;

import domain.AbstractDomainObject;
import domain.Klijent;
import domain.Termin;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOAddKlijent extends AbstractSO {

    public SOAddKlijent() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        klijent = (Klijent) databaseBroker.add((Klijent) object);
        System.out.println(klijent);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        Klijent klijent = (Klijent) object;

        if (!(object instanceof Klijent)) {
            throw new Exception("Object is not valid!");
        }
        if (klijent.getIme().isEmpty()) {
            throw new Exception("Polje ime ne sme biti prazno!");
        }
        if (klijent.getPrezime().isEmpty()) {
            throw new Exception("Polje prezime ne sme biti prazno!");
        }
    }

    private Klijent klijent;

    public Klijent getKlijent() {
        return klijent;
    }

}
