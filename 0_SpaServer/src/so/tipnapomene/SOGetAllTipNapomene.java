/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tipnapomene;

import domain.AbstractDomainObject;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetAllTipNapomene extends AbstractSO {

    private List<AbstractDomainObject> tipoviNapomene;

    public SOGetAllTipNapomene() throws Exception {
        super();
    }

    public List<AbstractDomainObject> getTipNapomene() {
        return tipoviNapomene;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        tipoviNapomene = databaseBroker.getAll(object);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
    }
}
