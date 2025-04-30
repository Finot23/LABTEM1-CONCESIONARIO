/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import consecionario.Clases.Seguro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author joms_
 */
public class SegurosBD {
    
    
    private Connection con;
    private PreparedStatement ps;
    
    
    public boolean RegistrarSeguro(Seguro s1){
     con = ConexionBD.conn();

        if (con == null) {
            System.out.println("No se pudo establecer conexión con la base de datos.");
            return false;
        }
        
     String sql = "INSERT INTO seguro (nombre, apellido_p, autoResumen, tipo_cobertura, periodo, metodo_pago, valor, prima) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      
     try{
        ps = con.prepareStatement(sql);
        ps.setString(1, s1.getNombreS());
        ps.setString(2, s1.getApellidoP());
        ps.setString(3, s1.getAutoResumen());
        ps.setString(4, s1.getCobertura());
        ps.setString(5, s1.getPeriodo());
        ps.setString(6, s1.getMetodoP());
        ps.setDouble(7, s1.getValor());
        ps.setDouble(8, s1.getPrima());
        
        ps.executeUpdate();
        return true;
        
    }catch (Exception e){
        System.out.println("Error al registrar seguro: " + e.getMessage());
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
