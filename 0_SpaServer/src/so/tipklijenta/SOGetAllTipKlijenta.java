/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tipklijenta;

import domain.AbstractDomainObject;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetAllTipKlijenta extends AbstractSO {

    public SOGetAllTipKlijenta() throws Exception {
        super();
    }
    private List<AbstractDomainObject> tipoviKlijenata;

    public List<AbstractDomainObject> getTipKlijenta() {
        return tipoviKlijenata;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        tipoviKlijenata = databaseBroker.getAll(object);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
    }
}
