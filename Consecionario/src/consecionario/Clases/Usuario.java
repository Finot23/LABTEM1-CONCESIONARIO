/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;


/**
 *
 * @author antoniosalinas
 */



public class Usuario {
    private int Id;
    private String Nombre;
    private String Contraseña;
    String Rol;
    String ApellidoP;
    String ApellidoM;
    String Puesto;
    String Nombres;
    
    public Usuario() {
    // Constructor vacío necesario para instanciar objetos sin parámetros
}

    public Usuario(int Id, String Nombre, String Contraseña, String Rol, String ApellidoP, String ApellidoM, String Puesto, String Nombres) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Puesto = Puesto;
        this.Nombres = Nombres;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public String getRol() {
        return Rol;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public String getPuesto() {
        return Puesto;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }
    
}