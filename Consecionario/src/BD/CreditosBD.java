package BD;

import consecionario.Clases.Credito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreditosBD {
    
     private Connection con;
    private PreparedStatement ps;
    
    
    public boolean RegistrarCredito(Credito c1){
     con = ConexionBD.conn();

        if (con == null) {
            System.out.println("No se pudo establecer conexión con la base de datos.");
            return false;
        }
        
     String sql = "INSERT INTO credito (automovil, precio_auto, porcentaje_enganche, enganche,monto_credito, plazo, pago_mensual) VALUES (?, ?, ?, ?, ?, ?, ?)";
      
     try{
        ps = con.prepareStatement(sql);
        ps.setString(1, c1.getModelo());
        ps.setDouble(2, c1.getValor_auto());
        ps.setString(3, c1.getPorcentajeEnganche());
        ps.setDouble(4, c1.getEnganche());
        ps.setDouble(5, c1.getCredito());
        ps.setInt(6, c1.getMeses());
        ps.setDouble(7, c1.getPago_mensual());
        
        ps.executeUpdate();
        return true;
        
    }catch (Exception e){
        System.out.println("Error al registrar credito: " + e.getMessage());
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
