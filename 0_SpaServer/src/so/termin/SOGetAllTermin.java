/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.termin;

import domain.AbstractDomainObject;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetAllTermin extends AbstractSO {

    public SOGetAllTermin() throws Exception {
        super();
    }
    private List<AbstractDomainObject> listaTermina=new ArrayList();

    
    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        listaTermina = databaseBroker.getAll(object);

    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
    }

    public List<AbstractDomainObject> getListaTermina() {
        return listaTermina;
    }

    public void setListaTermina(List<AbstractDomainObject> listaTermina) {
        this.listaTermina = listaTermina;
    }

   
    
}
