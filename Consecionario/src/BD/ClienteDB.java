/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;


import consecionario.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


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
        
     String sql = "INSERT INTO clientes (Id, Apellido_Paterno, Apellido_Materno, nombre, telefono, Correo, calle, colonia, municipio, estado , cp ,curp,licencia,genero,edad) VALUES (?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?,?,?,?)";
      
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
        
        ps.setString(10, cl.getEstado());
        ps.setString(11, cl.getCP());
        ps.setString(12, cl.getCurp());
        ps.setString(13, cl.getLicencia());
        ps.setString(14, cl.getGenero());
        ps.setInt(15, cl.getEdad());
        
        
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

 public Cliente buscarClientePorNombreYApellido(String nombre, String apellidoPaterno) {
        Connection con = ConexionBD.conn();
        if (con == null) {
            System.out.println("No se pudo establecer conexión con la base de datos.");
            return null;
        }
        
        String sql = "SELECT * FROM clientes WHERE nombre = ? AND Apellido_Paterno = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellidoPaterno);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidoP(rs.getString("Apellido_Paterno"));
                cliente.setApellidoM(rs.getString("Apellido_Materno"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setCorreo(rs.getString("Correo"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setColonia(rs.getString("colonia"));
                cliente.setMunicipio(rs.getString("municipio"));
                
                cliente.setEstado(rs.getString("estado"));
                cliente.setCP(rs.getString("cp"));
                cliente.setCurp(rs.getString("curp"));
                cliente.setLicencia(rs.getString("licencia"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setEdad(rs.getInt("edad"));
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return null;
    }

      }
              

    



