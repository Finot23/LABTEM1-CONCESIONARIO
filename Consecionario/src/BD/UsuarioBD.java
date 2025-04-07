package BD;

import consecionario.Usuario;
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
}