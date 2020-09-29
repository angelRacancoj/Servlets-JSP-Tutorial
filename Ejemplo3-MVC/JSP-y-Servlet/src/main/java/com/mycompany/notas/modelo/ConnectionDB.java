package com.mycompany.notas.modelo;

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
    
    private ConnectionDB(){
        String url = "jdbc:mysql://localhost:3306/notas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "miPassword";
        
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public static Connection getInstance(){
        if (connectionDB == null) {
            connectionDB = new ConnectionDB();
        }
        return connection;
    }
}
