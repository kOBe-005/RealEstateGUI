/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.util.ArrayList;

/**
 *
 * @author Asus-User
 */
public abstract class AbstractDAO<Objt> {
    public abstract ArrayList<Objt> displayInfo();
    
    public abstract ArrayList<Objt> displayInfo(String filter);
    
    public abstract String displayStatus(int id);

}
