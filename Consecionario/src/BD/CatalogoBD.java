/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import consecionario.Clases.CatalogoCarros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Finot
 */
public class CatalogoBD {
    private Connection con;
    private PreparedStatement ps;


public boolean RegistrarCarro(CatalogoCarros cl){
     con = ConexionBD.conn(); // Aquí sí guardamos en la variable de clase

        if (con == null) {
            System.out.println("No se pudo establecer conexión con la base de datos.");
            return false;
        }
        
     String sql = "INSERT INTO almacen (id, marca, modelo, año_fabricacion, precio, color, estado, categoria, imagen, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
     try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, cl.getId());
        ps.setString(2, cl.getMarca());
        ps.setString(3, cl.getModelo());
        ps.setString(4, cl.getAnioFabricacion());
        ps.setInt(5, cl.getPrecio());
        ps.setString(6, cl.getColor());
        ps.setString(7, cl.getEstado());
        ps.setString(8, cl.getCategoria());
        ps.setString(9, cl.getImagen());
        ps.setString(10, cl.getDescripcion());
        
        
        ps.executeUpdate();
        return true;
        
    }catch (Exception e){
        System.out.println("Error al registrar carro: " + e.getMessage());
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

public List<CatalogoCarros> obtenerPorCategoria(String categoria) {
    List<CatalogoCarros> lista = new ArrayList<>();
    con = ConexionBD.conn();

    if (con == null) {
        System.out.println("No se pudo establecer conexión con la base de datos.");
        return lista;
    }

    String sql = "SELECT * FROM almacen WHERE categoria = ?";

    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, categoria);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CatalogoCarros carro = new CatalogoCarros();
            carro.setId(rs.getInt("id"));
            carro.setMarca(rs.getString("marca"));
            carro.setModelo(rs.getString("modelo"));
            carro.setAnioFabricacion(rs.getString("año_fabricacion"));
            carro.setPrecio(rs.getInt("precio"));
            carro.setColor(rs.getString("color"));
            carro.setEstado(rs.getString("estado"));
            carro.setCategoria(rs.getString("categoria"));
            carro.setImagen(rs.getString("imagen"));
            carro.setDescripcion(rs.getString("descripcion"));
            lista.add(carro);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener por categoría: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }

    return lista;
}
}
