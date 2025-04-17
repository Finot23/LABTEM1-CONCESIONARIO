/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;

/**
 *
 * @author Finot
 */
public class CatalogoCarros {
    
  int Id;
    String Marca;
    String Modelo;
    String AnioFabricacion;
    int Precio;
    String Color;
    String Estado;
    String Categoria;
    String Imagen;
    String Descripcion;
public CatalogoCarros() {
    // Constructor vacío requerido para instanciar sin parámetros
}

    public CatalogoCarros(int Id, String Marca, String Modelo, String AnioFabricacion, int Precio, String Color, String Estado, String Categoria, String Imagen, String Descripcion) {
        this.Id = Id;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.AnioFabricacion = AnioFabricacion;
        this.Precio = Precio;
        this.Color = Color;
        this.Estado = Estado;
        this.Categoria = Categoria;
        this.Imagen = Imagen;
        this.Descripcion = Descripcion;
    }

    public int getId() {
        return Id;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
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
        return Estado;
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

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
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

    public void setEstado(String Estado) {
        this.Estado = Estado;
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


