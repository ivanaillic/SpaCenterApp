/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.termin;

import domain.AbstractDomainObject;
import domain.Termin;
import java.util.List;
import so.AbstractSO;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Ivana
 */
public class SOGetAllTerminiByDatum extends AbstractSO {

private List<AbstractDomainObject> filteredTermini = new ArrayList<>();
    private Timestamp datum;

    public SOGetAllTerminiByDatum(Timestamp datum) throws Exception {
        super();
        this.datum = datum;
    }

    @Override
    protected void executeOperation(AbstractDomainObject object) throws Exception {
        Termin termin = new Termin();
        termin.setDatumVremeTermina(new Timestamp(datum.getTime())); 
        System.out.println("Datum termina za filtriranje: " + datum);
        filteredTermini = databaseBroker.getAllConditon(termin);
        
    }

    @Override
    protected void validate(AbstractDomainObject object) throws Exception {
        
    }

    public List<AbstractDomainObject> getTermini() {
        return filteredTermini;
    }
}
