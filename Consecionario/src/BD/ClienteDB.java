/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;


import consecionario.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author antoniosalinas
 */ 
  public class ClienteDB {
    
      private Connection con;
      private PreparedStatement ps;

public boolean RegistrarClientes(Cliente cl){
     con = ConexionBD.conn(); // Aquí sí guardamos en la variable de clase

        if (con == null) {
            System.out.println("No se pudo establecer conexión con la base de datos.");
            return false;
        }
        
     String sql = "INSERT INTO clientes (Id, Apellido_Paterno, Apellido_Materno, nombre, telefono, Correo, calle, colonia, municipio, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
     try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, cl.getId());
        ps.setString(2, cl.getApellidoP());
        ps.setString(3, cl.getApellidoM());
        ps.setString(4, cl.getNombre());
        ps.setLong(5, cl.getTelefono());
        ps.setString(6, cl.getCorreo());
        ps.setString(7, cl.getCalle());
        ps.setString(8, cl.getColonia());
        ps.setString(9, cl.getMunicipio());
        ps.setString(10, cl.getCiudad());
        
        ps.executeUpdate();
        return true;
        
    }catch (Exception e){
        System.out.println("Error al registrar cliente: " + e.getMessage());
        return false;
    } finally {
        try {
            if (ps != null) ps.close();
            if(con !=null) con.close();
        } catch (SQLException e){
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}
      }
              

    



