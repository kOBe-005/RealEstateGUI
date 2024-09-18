/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.awt.Desktop;
import javax.swing.JOptionPane;
import java.io.File;

/**
 *
 * @author Administrator
 */
public class OpenPdf  {
    public static void openById(String id){
       try {
            // Ensure to include the backslash in the file path
            String filePath = "C:\\" + id + ".pdf";
            File file = new File(filePath);
            
            System.out.println("Checking file: " + filePath);
            
            // Check if the file exists
            if (file.exists()) {
                // Use Desktop to open the file
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(null, "File does not exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

