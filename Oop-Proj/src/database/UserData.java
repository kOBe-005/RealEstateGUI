/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;

/**
 *
 * @author Asus-User
 */
public class UserData {

    public static void save(User user) {
        String Query = "insert into user(name, email, mobileNumber, address, password, securityQuestion, answer, status) values('" + user.getName() + "', '" + user.getEmail() + "', '" + user.getMobileNumber() + "', '" + user.getAddress() + "', '" + user.getPassword() + "', '" + user.getSecurityQuestion() + "', '" + user.getAnswer() + "', 'false')";
        DbOperations.setDataOrDelete(Query, "Register Successfully!");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select * from user where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            String query = "SELECT * FROM user WHERE email = '" + email + "'";
            System.out.println("Executing query: " + query);  // Debug statement
            ResultSet rs = DbOperations.getData("Select * from user where email = '" + email + "'");
            while (rs != null && rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static void update(String email, String newPassword) {
        String query = "update user set password = '" + newPassword + "' where email = '" + email + "'";
        DbOperations.setDataOrDelete(query, "Password Changed Successfully");
    }

}//END 
