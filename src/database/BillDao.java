/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import model.Bill;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class BillDao extends AbstractDAO {
    @Override
    public ArrayList<Bill> displayInfo() {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM bill");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setEmail(rs.getString("email"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                arrayList.add(bill);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Bill> displayInfo(String filter) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM bill WHERE email LIKE '%" + filter + "%'");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setEmail(rs.getString("email"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                arrayList.add(bill);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    @Override
    public String displayStatus(int id) {
        String status = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT status FROM bill WHERE id=" + id);
            if (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return status;
    }
    
    
    public static String getId(){
        int id = 1;
        try{
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if(rs.next()){
                    id = rs.getInt(1);
                    id = id + 1;
            
                    }
        }
            catch(SQLException e){
             JOptionPane.showMessageDialog(null, e);    
                    
        }
        return String.valueOf(id);
    }
 
    public static void save(Bill bill){
     String query = "insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobileNumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getcreatedBy()+"')";
    DbOperations.setDataOrDelete(query,"Bill Details Added Successfully");
    }
  
    public static ArrayList<Bill> getAllRecordsbyInc(String date) {
    ArrayList<Bill> arrayList = new ArrayList<>();
    try {
        ResultSet rs = DbOperations.getData("select * from bill where date like '%" + date +"%'");
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("name"));
            bill.setMobileNumber(rs.getString("mobileNumber"));
            bill.setEmail(rs.getString("email"));
            bill.setDate(rs.getString("date"));
            bill.setTotal(rs.getString("total"));
            bill.setcreatedBy(rs.getString("createdBy"));
            arrayList.add(bill);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return arrayList;
}

public static ArrayList<Bill> getAllRecordsbyDesc(String date) {
    ArrayList<Bill> arrayList = new ArrayList<>();
    try {
        ResultSet rs = DbOperations.getData("select * from bill where date like '%" + date +"%' order by id DESC");
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("name"));
            bill.setMobileNumber(rs.getString("mobileNumber"));
            bill.setEmail(rs.getString("email"));
            bill.setDate(rs.getString("date"));
            bill.setTotal(rs.getString("total"));
            bill.setcreatedBy(rs.getString("createdBy"));
            arrayList.add(bill);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return arrayList;
}

    
}
