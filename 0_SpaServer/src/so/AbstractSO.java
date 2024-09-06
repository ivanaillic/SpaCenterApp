/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DatabaseBroker;
import db.DatabaseConnection;
import domain.AbstractDomainObject;
import java.sql.SQLException;

/**
 *
 * @author Ivana
 */
public abstract class AbstractSO {
    
    protected DatabaseBroker databaseBroker;

    public AbstractSO() throws Exception {
        databaseBroker = new DatabaseBroker(DatabaseConnection.getInstance().pop());
    }

    public void execute(AbstractDomainObject object) throws Exception {
        try {
            validate(object);
            executeOperation(object);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        }
    }

    private void commit() throws SQLException {
        databaseBroker.getConnection().commit();
    }

    private void rollback() throws SQLException {
        databaseBroker.getConnection().rollback();
    }

    protected abstract void executeOperation(AbstractDomainObject object) throws Exception;

    protected abstract void validate(AbstractDomainObject object) throws Exception;

    
    
    
}
