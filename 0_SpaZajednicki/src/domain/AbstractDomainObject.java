/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ivana
 */
public abstract class AbstractDomainObject {

    public abstract String getTableName();

    public abstract String getColumnsForInsert();

    public abstract String getParamsForInsert();

    public abstract void setParamsForInsert(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException;

    public abstract String getColumnsForUpdate();

    public abstract String getParamsForUpdate();

    public abstract void setParamsForUpdate(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException;
 
    public abstract Long getPrimaryKeyValue();
    
    public abstract String alias();
    
    public abstract String join();
    
    public abstract  List<AbstractDomainObject> getList(ResultSet rs);
    
    public abstract  String getPrimaryKey();

    public abstract void setAutoIncrementPrimaryKey(long generatedKey);
    
    public abstract String conditon();
    
    public abstract Object setCondition();
    
    public abstract AbstractDomainObject getObject(ResultSet rs) throws SQLException;
    
}
