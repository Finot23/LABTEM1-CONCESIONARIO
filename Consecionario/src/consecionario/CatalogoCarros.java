/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario;

/**
 *
 * @author Finot
 */
public class CatalogoCarros {
    
    int Id;
    String modelo;
    String AnioFabricacion;
    int Precio;
    String Color;
    String estado;
    String Categoria;
    String Imagen;
    String Descripcion;

    public CatalogoCarros(int Id, String modelo, String AnioFabricacion, int Precio, String Color, String estado, String Categoria, String Imagen, String Descripcion) {
        this.Id = Id;
        this.modelo = modelo;
        this.AnioFabricacion = AnioFabricacion;
        this.Precio = Precio;
        this.Color = Color;
        this.estado = estado;
        this.Categoria = Categoria;
        this.Imagen = Imagen;
        this.Descripcion = Descripcion;
    }

    public int getId() {
        return Id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnioFabricacion() {
        return AnioFabricacion;
    }

    public int getPrecio() {
        return Precio;
    }

    public String getColor() {
        return Color;
    }

    public String getEstado() {
        return estado;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getImagen() {
        return Imagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnioFabricacion(String AnioFabricacion) {
        this.AnioFabricacion = AnioFabricacion;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
