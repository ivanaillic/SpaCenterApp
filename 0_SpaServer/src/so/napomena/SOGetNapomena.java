/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.napomena;

import domain.AbstractDomainObject;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetNapomena extends AbstractSO{

    public SOGetNapomena() throws Exception {
        super();
    }
    

    private List<AbstractDomainObject> usluge;

    public List<AbstractDomainObject> getUsluge() {
        return usluge;
    }
    
    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
  
       usluge= databaseBroker.getAllConditon(object);
        
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
    }
    
}
