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
public class SODeleteKlijent  extends AbstractSO{

    public SODeleteKlijent() throws Exception {
        super();
    }

    
    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {

        databaseBroker.delete(object);

    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {

    }


    
}
