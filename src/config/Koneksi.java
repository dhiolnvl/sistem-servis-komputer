/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author ASUS
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {
    
    protected Connection connection;
    protected Statement stmt;

    public Koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/komputer", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver error: " + ex.getMessage());
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Statement createStatement() throws SQLException {
        return stmt = connection.createStatement();
    }

    public Connection getConnection() {
        return connection;
    }
}
