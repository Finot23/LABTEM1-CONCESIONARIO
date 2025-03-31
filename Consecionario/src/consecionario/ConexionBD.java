/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author antoniosalinas
 */
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:80/Concesionaria";
    private static final String USER = "root"; // Usuario por defecto en XAMPP
    private static final String PASSWORD = ""; // Déjala en blanco si no la configuraste

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        conectar();
    }

}
