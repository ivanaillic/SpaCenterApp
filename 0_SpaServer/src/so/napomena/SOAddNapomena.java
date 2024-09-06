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
public class SOAddNapomena extends AbstractSO {

    private NapomenaZaUslugu napomena;

    public SOAddNapomena() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        napomena = (NapomenaZaUslugu) databaseBroker.add(object);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        napomena = (NapomenaZaUslugu) object;

        if (napomena == null) {
            throw new Exception("Napomena za uslugu je null");
        }

        if (napomena.getOpisNapomene() == null || napomena.getOpisNapomene().isEmpty()) {
            throw new Exception("Tekst napomene za uslugu je obavezan.");
        }
        if (napomena.getTipNapomene() == null) {
            throw new Exception("Tip napomene za uslugu nije izabran.");
        }
    }

}
