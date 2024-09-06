/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vrstausluge;
import domain.AbstractDomainObject;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetAllVrstaUsluge extends AbstractSO {

    public SOGetAllVrstaUsluge() throws Exception {
        super();
    }
    private List<AbstractDomainObject> vrsteUsluga;

    public List<AbstractDomainObject> getVrstaUsluge() {
        return vrsteUsluga;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        vrsteUsluga = databaseBroker.getAll(object);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
    }
}
