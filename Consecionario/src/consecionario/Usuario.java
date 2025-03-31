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
    private int id;
    private String nombre;
    private String contaseña;
    int rol;

    public Usuario(int id, String nombre, String contaseña, int rol) {
        this.id = id;
        this.nombre = nombre;
        this.contaseña = contaseña;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContaseña() {
        return contaseña;
    }

    public int getRol() {
        return rol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContaseña(String contaseña) {
        this.contaseña = contaseña;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
 
    
}
