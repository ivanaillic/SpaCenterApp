/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.usluga;

import domain.AbstractDomainObject;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetAllUsluga extends AbstractSO{

    public SOGetAllUsluga() throws Exception {
        super();
    }
    private List<AbstractDomainObject> listaUsluga=new ArrayList();

    
    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        listaUsluga = databaseBroker.getAll(object);

    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
    }

    public List<AbstractDomainObject> getListaUsluga() {
        return listaUsluga;
    }

    public void setListaUsluga(List<AbstractDomainObject> listaUsluga) {
        this.listaUsluga = listaUsluga;
    }
   
    
    
}
