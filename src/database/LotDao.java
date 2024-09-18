/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Lot;
import java.sql.*;

/**
 *
 * @author Julianna Boado
 */

//replace the word category to block
//replace the word product to lot
//added area in the save,getAllRecords, and update


public class LotDao extends AbstractDAO {
    @Override
    public ArrayList<Lot> displayInfo() {
        ArrayList<Lot> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM lot");
            while (rs.next()) {
                Lot lotInfo = new Lot();
                lotInfo.setId(rs.getInt("id"));
                lotInfo.setName(rs.getString("name"));
                arrayList.add(lotInfo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Lot> displayInfo(String filter) {
        ArrayList<Lot> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM lot WHERE email LIKE '%" + filter + "%'");
            while (rs.next()) {
                Lot lotInfo = new Lot();
                lotInfo.setId(rs.getInt("id"));
                lotInfo.setName(rs.getString("name"));
                arrayList.add(lotInfo);
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
            ResultSet rs = DbOperations.getData("SELECT status FROM lot WHERE id=" + id);
            if (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return status;
    }
    
    
    public static void save(Lot lot) {
    String query = "INSERT into lot (name,block,area,price) values('" + lot.getName() + "','" + lot.getBlock() + "','" + lot.getArea() + "','" + lot.getPrice() + "')";
    DbOperations.setDataOrDelete(query, "Lot Added Successfully");
    }
    
    public static ArrayList<Lot> getAllRecords(){
        ArrayList<Lot> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT *from lot");
            while(rs.next()) {
                Lot lot = new Lot();
                lot.setId(rs.getInt("id"));
                lot.setName(rs.getString("name"));
                lot.setBlock(rs.getString("block"));
                lot.setArea(rs.getString("area"));
                lot.setPrice(rs.getString("price"));
                arrayList.add(lot);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void update(Lot lot) {
        String query = "UPDATE lot set name ='"+lot.getName()+"', block ='"+lot.getBlock()+"', price ='"+lot.getPrice()+"' where id ='"+lot.getId()+"'";
        
        //String query = "UPDATE lot set name ='"+lot.getName()+"', block ='"+lot.getBlock()+"', area ='"+lot.getArea()+"', price ='"+lot.getPrice()+"' where id ='"+lot.getId()+"'";

        DbOperations.setDataOrDelete(query, "Lot Updated Successfully");
    }
    
    public static void delete(String id) {
        String query = "delete from lot where id = '"+id+"'";
        DbOperations.setDataOrDelete(query, "Lot Deleted Successfully");
    }
    
   public static ArrayList<Lot> getAllRecordsByBlock(String block) {
    ArrayList<Lot> arrayList = new ArrayList<>();
    try {
    ResultSet rs = DbOperations.getData("SELECT * from lot where block = '" + block + "'");
        while (rs.next()) {
            Lot lot = new Lot();
            lot.setName(rs.getString("name"));
            arrayList.add(lot);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return arrayList;
}
    
    public static ArrayList<Lot> filterLotByname(String name, String block) {
    ArrayList<Lot> arrayList = new ArrayList<>();
    try {
        ResultSet rs = DbOperations.getData("SELECT * from lot where name like '%"+name+"%' and block ='"+block+"'");
        //"SELECT * from lot where name like '%"+name+"%' and block ='"+block"'";
        
        while (rs.next()) {
            Lot lot = new Lot();
            lot.setName(rs.getString("name"));
            arrayList.add(lot);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return arrayList;
}

public static Lot getLotByName(String name) {
    Lot lot = new Lot();

    try {
        ResultSet rs = DbOperations.getData("SELECT * from lot where name='" + name+"'");

        while (rs.next()) {
            lot.setName(rs.getString(2));
            lot.setBlock(rs.getString(3));
            lot.setArea(rs.getString(4)); // add this
            lot.setPrice(rs.getString(5));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    return lot;
}



}
