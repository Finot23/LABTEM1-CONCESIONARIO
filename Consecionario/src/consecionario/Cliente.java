/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario;

/**
 *
 * @author antoniosalinas
 */
public class Cliente {
    int Id;
    String ApellidoP;
    String ApellidoM;
    String Nombre;
    long Telefono;
    String Correo;
    String Curp;
    
    String Calle;
    String Colonia;
    String Municipio;
    String Ciudad;
    String Estado;
    String CP;
    String Licencia;
    String Genero;
    int Edad;
    
    
    public Cliente(){
    
}
    /*
    String Marca;
    String Modelo;
    String TipoCarro;
    String ColorCarro;
    int Año;
    String Condicion;
*/
    public Cliente(String Municipio, String Ciudad) {
        this.Municipio = Municipio;
        this.Ciudad = Ciudad;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    
    
    
  

    public Cliente(int Id, String ApellidoP, String ApellidoM, String Nombre, String Calle, String Colonia, String Estado, String CP, String Marca, String Modelo, String TipoCarro, String ColorCarro, int Año, String Condicion, long Telefono, String Correo,String Curp,String Licencia,String Genero,int Edad) {
        this.Id = Id;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Nombre = Nombre;
        this.Calle = Calle;
        this.Colonia = Colonia;
        this.Estado = Estado;
        this.CP = CP;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Curp = Curp;
        this.Licencia = Licencia;
        this.Genero = Genero;
        this.Edad = Edad;
        
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

   

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getId() {
        return Id;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCalle() {
        return Calle;
    }

    public String getColonia() {
        return Colonia;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCP() {
        return CP;
    }

    public long getTelefono() {
        return Telefono;
    }

    public String getCorreo() {
        return Correo;
    }
    
    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getLicencia() {
        return Licencia;
    }

    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
}