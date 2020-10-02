package com.notas.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author orlan
 */
public class ConnectionDB {

    private static Connection connection = null;
    private static ConnectionDB connectionDB;

    private ConnectionDB() {
        String url = "jdbc:mysql://localhost:3306/NOTAS?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "MySQL-Pass";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, password);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error DB: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (connectionDB == null) {
            connectionDB = new ConnectionDB();
        }
        return connection;
    }
}
