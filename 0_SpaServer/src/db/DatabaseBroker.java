package db;

import domain.AbstractDomainObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivana
 */
public class DatabaseBroker {

    private final Connection connection;

    public DatabaseBroker(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public AbstractDomainObject getObjectByCondition(AbstractDomainObject domainObject, String condition, Object... params) throws SQLException {
        String query = "SELECT * FROM " + domainObject.getTableName() + " WHERE " + condition;
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof String) {
                statement.setString(i + 1, (String) params[i]);
            } else if (params[i] instanceof Long) {
                statement.setLong(i + 1, (Long) params[i]);
            } else if (params[i] instanceof Integer) {
                statement.setInt(i + 1, (Integer) params[i]);
            } else if (params[i] instanceof Timestamp) {
                statement.setTimestamp(i + 1, (Timestamp) params[i]);
            } else {
                throw new IllegalArgumentException("Nepodržan tip podataka.");
            }
        }

        ResultSet rs = statement.executeQuery();
        AbstractDomainObject result = null;
        if (rs.next()) {
            result = domainObject.getObject(rs);
        }

        rs.close();
        statement.close();

        return result;
    }

    public List<AbstractDomainObject> getAll(AbstractDomainObject domainObject) throws SQLException {
        List<AbstractDomainObject> list = new ArrayList<>();
        String query = "SELECT * FROM " + domainObject.getTableName() + domainObject.join();
        System.out.println("SQL upit je: " + query);

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        list.addAll(domainObject.getList(rs));

        rs.close();
        statement.close();

        return list;
    }

    public AbstractDomainObject add(AbstractDomainObject domainObject) throws SQLException {
        String query = "INSERT INTO " + domainObject.getTableName()
                + domainObject.getColumnsForInsert() + " VALUES " + domainObject.getParamsForInsert();
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        domainObject.setParamsForInsert(statement, domainObject);
        int result = statement.executeUpdate();
        ResultSet rsID = statement.getGeneratedKeys();
        while (rsID.next()) {
            long generatedKey = rsID.getLong(1);
            domainObject.setAutoIncrementPrimaryKey(rsID.getLong(1));
        }
        rsID.close();
        statement.close();

        return domainObject;
    }

    public List<AbstractDomainObject> getAllConditon(AbstractDomainObject domainObject) throws SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        List<AbstractDomainObject> list = new ArrayList<>();

        String query = "SELECT * FROM " + domainObject.getTableName() + domainObject.join() + " WHERE " + domainObject.conditon() + "= ?";
        System.out.println("SQL upit je: " + query);

        PreparedStatement statement = connection.prepareStatement(query);

        Object condition = domainObject.setCondition();
        System.out.println("condition " + condition.toString());
        if (condition instanceof Long) {
            statement.setLong(1, (Long) condition);
        } else if (condition instanceof String) {
            statement.setString(1, (String) condition);
        } else if (condition instanceof Timestamp) {
            statement.setTimestamp(1, (Timestamp) condition);
        } else {
            throw new IllegalArgumentException("Nepodržan tip podataka za uslov pretrage");
        }

        ResultSet rs = statement.executeQuery();

        list.addAll(domainObject.getList(rs));

        rs.close();
        statement.close();

        return list;
    }

    public void delete(AbstractDomainObject domainObject) throws Exception {
        String query = "DELETE FROM " + domainObject.getTableName() + " WHERE " + domainObject.getPrimaryKey() + " =?";
        System.out.println("izraz je: " + query);
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setLong(1, domainObject.getPrimaryKeyValue());
        int result = statement.executeUpdate();

        statement.close();
    }

    public void update(AbstractDomainObject domainObject) throws SQLException {
        String query = "UPDATE " + domainObject.getTableName()
                + domainObject.getParamsForUpdate()
                + " WHERE " + domainObject.getPrimaryKey() + " =?";
        System.out.println("SQL upit za ažuriranje: " + query);
        PreparedStatement statement = connection.prepareStatement(query);

        domainObject.setParamsForUpdate(statement, domainObject);

        int result = statement.executeUpdate();

        statement.close();
    }
}
