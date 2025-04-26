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
        
     String sql = "INSERT INTO almacen (id, marca, modelo, anio_fabricacion, no_serie, precio, color, estado, categoria, imagen, descripcion, kilometraje) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
     try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, cl.getId());
        ps.setString(2, cl.getMarca());
        ps.setString(3, cl.getModelo());
        ps.setInt(4, cl.getAnioFabricacion());
        ps.setString(5, cl.getNoSerie());
        ps.setDouble(6, cl.getPrecio());
        ps.setString(7, cl.getColor());
        ps.setString(8, cl.getEstado());
        ps.setString(9, cl.getCategoria());
        ps.setString(10, cl.getImagen());
        ps.setString(11, cl.getDescripcion());
        ps.setLong(12, cl.getKilometraje());
        
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

    // Si la categoría es "Todos", obtenemos todos los autos
    String sql = categoria.equals("Todos") ? "SELECT * FROM almacen" : "SELECT * FROM almacen WHERE categoria = ?";

    try {
        ps = con.prepareStatement(sql);

        if (!categoria.equals("Todos")) {
            ps.setString(1, categoria);
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CatalogoCarros carro = new CatalogoCarros();
            carro.setId(rs.getInt("id"));
            carro.setMarca(rs.getString("marca"));
            carro.setModelo(rs.getString("modelo"));
            carro.setAnioFabricacion(rs.getInt("anio_fabricacion"));
            carro.setNoSerie(rs.getString("no_serie"));
            carro.setPrecio(rs.getDouble("precio"));
            carro.setColor(rs.getString("color"));
            carro.setEstado(rs.getString("estado"));
            carro.setCategoria(rs.getString("categoria"));
            carro.setImagen(rs.getString("imagen"));
            carro.setDescripcion(rs.getString("descripcion"));
            carro.setKilometraje(rs.getLong("kilometraje"));
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

public List<CatalogoCarros> obtenerPorCondicion(String condicion) {
    List<CatalogoCarros> lista = new ArrayList<>();
    con = ConexionBD.conn();

    if (con == null) {
        System.out.println("No se pudo establecer conexión con la base de datos.");
        return lista;
    }

    String sql = "SELECT * FROM almacen WHERE estado = ?"; // Asumo que la columna para la condición es 'estado'

    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, condicion); // "Nuevo" o "Usado"

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CatalogoCarros carro = new CatalogoCarros();
            carro.setId(rs.getInt("id"));
            carro.setMarca(rs.getString("marca"));
            carro.setModelo(rs.getString("modelo"));
            carro.setAnioFabricacion(rs.getInt("anio_fabricacion"));
            carro.setNoSerie(rs.getString("no_serie"));
            carro.setPrecio(rs.getDouble("precio"));
            carro.setColor(rs.getString("color"));
            carro.setEstado(rs.getString("estado"));
            carro.setCategoria(rs.getString("categoria"));
            carro.setImagen(rs.getString("imagen"));
            carro.setDescripcion(rs.getString("descripcion"));
            carro.setKilometraje(rs.getLong("kilometraje"));
            lista.add(carro);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener por condición: " + e.getMessage());
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

public List<CatalogoCarros> filtrarPorMultiples(List<String> tipos, List<String> condiciones) {
    List<CatalogoCarros> lista = new ArrayList<>();
    con = ConexionBD.conn();

    if (con == null) {
        System.out.println("No se pudo establecer conexión con la base de datos.");
        return lista;
    }

    StringBuilder sql = new StringBuilder("SELECT * FROM almacen WHERE 1=1");

    if (tipos != null && !tipos.isEmpty()) {
        sql.append(" AND categoria IN (");
        sql.append(String.join(",", tipos.stream().map(t -> "?").toArray(String[]::new)));
        sql.append(")");
    }

    if (condiciones != null && !condiciones.isEmpty()) {
        sql.append(" AND estado IN (");
        sql.append(String.join(",", condiciones.stream().map(c -> "?").toArray(String[]::new)));
        sql.append(")");
    }

    try {
        ps = con.prepareStatement(sql.toString());

        int index = 1;
        if (tipos != null && !tipos.isEmpty()) {
            for (String tipo : tipos) {
                ps.setString(index++, tipo);
            }
        }
        if (condiciones != null && !condiciones.isEmpty()) {
            for (String condicion : condiciones) {
                ps.setString(index++, condicion);
            }
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CatalogoCarros carro = new CatalogoCarros();
            carro.setId(rs.getInt("id"));
            carro.setMarca(rs.getString("marca"));
            carro.setModelo(rs.getString("modelo"));
            carro.setAnioFabricacion(rs.getInt("anio_fabricacion"));
            carro.setNoSerie(rs.getString("no_serie"));
            carro.setPrecio(rs.getDouble("precio"));
            carro.setColor(rs.getString("color"));
            carro.setEstado(rs.getString("estado"));
            carro.setCategoria(rs.getString("categoria"));
            carro.setImagen(rs.getString("imagen"));
            carro.setDescripcion(rs.getString("descripcion"));
            carro.setKilometraje(rs.getLong("kilometraje"));
            lista.add(carro);
        }

        rs.close();
    } catch (SQLException e) {
        System.out.println("Error al filtrar por múltiples: " + e.getMessage());
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
