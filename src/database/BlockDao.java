/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Block;
import java.sql.*;

/**
 *
 * @author Julianna Boado
 */

// Original name was Category Block but i changed it to BlockDao
// i changed every category word to block
//I also update the sql table so the category table is now block table 

public class BlockDao extends AbstractDAO {
    @Override
    public ArrayList<Block> displayInfo() {
        ArrayList<Block> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM block");
            while (rs.next()) {
                Block user = new Block();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                arrayList.add(user);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Block> displayInfo(String filter) {
        ArrayList<Block> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM block WHERE email LIKE '%" + filter + "%'");
            while (rs.next()) {
                Block user = new Block();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                arrayList.add(user);
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
            ResultSet rs = DbOperations.getData("SELECT status FROM block WHERE id=" + id);
            if (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return status;
    }
    
    
    public static void save(Block block){
        String query = "INSERT into block (name) values('" + block.getName() + "')";
        DbOperations.setDataOrDelete(query, "Block Added Sucessfully");
    }
    
    public static ArrayList<Block> getAllRecords(){
        ArrayList<Block> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT *from block");
            while(rs.next()){
                Block block = new Block();
                block.setId(rs.getInt("id"));
                block.setName(rs.getString("name"));
                arrayList.add(block);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void delete(String id){
        String query = "DELETE from block where id = " + id + ";";
        DbOperations.setDataOrDelete(query, "Block Deleted Sucessfully");
    }      
}
