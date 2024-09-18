/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionProvider {
    private static Connection con;

    private ConnectionProvider() {
        // private constructor
    }

    public static Connection getCon() {
        if (con == null) {
            synchronized (ConnectionProvider.class) {
                if (con == null) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/real_estate_finalProj", "root", "aniban_2023");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        return con;
    }
}

