package BD;

import consecionario.Clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioBD {
    private Connection con;
    private PreparedStatement ps;

    public Usuario CargarUsuarios(int id, String usuario, String contraseña) {
    con = ConexionBD.conn();
    
    if (con == null) {
        System.out.println("No se pudo establecer conexion con la base de datos.");
        return null;
    }

    String sql = "SELECT * FROM userlogin WHERE id = ? AND nombre_usuario = ? AND contraseña_usuario = ?";
    Usuario user = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, usuario);
        ps.setString(3, contraseña);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user = new Usuario();
            user.setId(rs.getInt("id"));
            user.setNombre(rs.getString("nombre_usuario"));
            user.setContraseña(rs.getString("contraseña_usuario"));
            user.setRol(rs.getString("rol"));
            user.setNombres(rs.getString("nombres"));
            user.setApellidoP(rs.getString("apellido_P"));
            user.setApellidoM(rs.getString("apellido_M"));
            user.setPuesto(rs.getString("puesto"));
        }

        rs.close();
    } catch (Exception e) {
        System.out.println("Error al registrar cliente: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }

    return user; // este es el usuario cargado o null si no se encontró
}
    

    public boolean crearUsuario(Usuario usuario) {
    con = ConexionBD.conn();
    
    if (con == null) {
        System.out.println("No se pudo establecer conexión con la base de datos.");
        return false;
    }

    String sql = "INSERT INTO userlogin (nombre_usuario, contraseña_usuario, rol, nombres, apellido_P, apellido_M, puesto) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getContraseña());
        ps.setString(3, usuario.getRol());
        ps.setString(4, usuario.getNombres());
        ps.setString(5, usuario.getApellidoP());
        ps.setString(6, usuario.getApellidoM());
        ps.setString(7, usuario.getPuesto());

        int resultado = ps.executeUpdate();
        return resultado > 0;
        
    } catch (SQLException e) {
        System.out.println("Error al crear usuario: " + e.getMessage());
        return false;
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}
}