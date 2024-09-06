/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.usluga;

import domain.AbstractDomainObject;
import domain.Usluga;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Ivana
 */
public class SOGetAllUslugaByNaziv extends AbstractSO {

    private List<AbstractDomainObject> filteredUsluge = new ArrayList<>();
    private String nazivUsluge;

    public SOGetAllUslugaByNaziv() throws Exception {
        super();
    }

    public void setNazivUsluge(String nazivUsluge) {
        this.nazivUsluge = nazivUsluge;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        Usluga usluga = new Usluga();
        usluga.setNazivUsluge(((Usluga)object).getNazivUsluge());
        filteredUsluge = databaseBroker.getAllConditon(usluga);
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        
    }

    public List<AbstractDomainObject> getFilteredUsluge() {
        return filteredUsluge;
    }
}

