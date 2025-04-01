/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author antoniosalinas
 */
public class ConexionBD {
   public static Connection conn(){
       try{
           String url = "jdbc:mysql://localhost:3306/Concesionaria";
           String user = "admin";
           String password = "admin";
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url, user, password);
           return conn;
       }catch(SQLException|ClassNotFoundException e){
           JOptionPane.showMessageDialog(null, e);
         
       }
       
   
return null;
}
}
