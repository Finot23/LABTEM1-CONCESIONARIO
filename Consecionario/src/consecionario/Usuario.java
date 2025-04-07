/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario;


/**
 *
 * @author antoniosalinas
 */



public class Usuario {
    private int Id;
    private String Nombre;
    private String Contraseña;
    String Rol;

    public Usuario(int Id, String Nombre, String Contraseña, String  Rol) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
    }

    public Usuario() {
        
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

    public String  getRol() {
        return Rol;
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

    public void setRol(String  Rol) {
        this.Rol = Rol;
    }

    
   
    }
