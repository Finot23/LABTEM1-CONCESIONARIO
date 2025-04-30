package consecionario.Clases;

/**
 *
 * @author Finot
 */
public class CatalogoCarros {
    
    int Id;
    String Marca;
    String Modelo;
    int AnioFabricacion;
    double Precio;
    String Color;
    String Estado;
    String Categoria;
    String Imagen;
    String Descripcion;
    Long Kilometraje;
    String NoSerie;
    
public CatalogoCarros() {
  
}

    public void setNoSerie(String NoSerie) {
        this.NoSerie = NoSerie;
    }

    public String getNoSerie() {
        return NoSerie;
    }

    public CatalogoCarros(String NoSerie) {
        this.NoSerie = NoSerie;
    }

    public CatalogoCarros(int Id, String Marca, String Modelo, int AnioFabricacion, double Precio, String Color, String Estado, String Categoria, String Imagen, String Descripcion, Long Kilometraje) {
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
        this.Kilometraje = Kilometraje;
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

    public int getAnioFabricacion() {
        return AnioFabricacion;
    }

    public double getPrecio() {
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

    public Long getKilometraje() {
        return Kilometraje;
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

    public void setAnioFabricacion(int AnioFabricacion) {
        this.AnioFabricacion = AnioFabricacion;
    }

    public void setPrecio(double Precio) {
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

    public void setKilometraje(Long Kilometraje) {
        this.Kilometraje = Kilometraje;
    }

}


