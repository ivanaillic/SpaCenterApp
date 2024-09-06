/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Ivana
 */
public class DatabaseConnection {

    private List<Connection> connectionPool;
    private static DatabaseConnection instance;

    private DatabaseConnection() throws SQLException, FileNotFoundException {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                
                Properties properties=new Properties();
                FileReader reader=new FileReader("C:\\Users\\pc\\Desktop\\SPA centar\\0_SpaServer\\src\\properties\\db.properties");
                try {
                    properties.load(reader);
                } catch (IOException ex) {
                    Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                }

                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");
                Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("The database connection has been successfully established.!");

               
                connection.setAutoCommit(false);
                connectionPool.add(connection);
            } catch (SQLException ex) {
                System.out.println("Error! The database connection was not successfully established.!\n" + ex.getMessage());
                ex.printStackTrace();
                throw ex;
            }
        }
    }

    public static DatabaseConnection getInstance() throws SQLException,  FileNotFoundException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public synchronized void push(Connection connection) {
        connectionPool.add(connection);
    }

    public synchronized Connection pop() throws Exception {
        if (connectionPool.isEmpty()) {
            throw new Exception("No available connection");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }
}
