/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consecionario.Clases;

import java.util.ArrayList;
import java.util.List;

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
    String Estado;
    String CP;
    String Licencia;
    String Genero;
    int Edad;
    
    public Cliente(){
    
}

    public Cliente(int Id, String ApellidoP, String ApellidoM, String Nombre, long Telefono, String Correo, String Curp, String Calle, String Colonia, String Municipio, String Estado, String CP, String Licencia, String Genero, int Edad) {
        this.Id = Id;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Curp = Curp;
        this.Calle = Calle;
        this.Colonia = Colonia;
        this.Municipio = Municipio;
        this.Estado = Estado;
        this.CP = CP;
        this.Licencia = Licencia;
        this.Genero = Genero;
        this.Edad = Edad;
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

    public long getTelefono() {
        return Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getCurp() {
        return Curp;
    }

    public String getCalle() {
        return Calle;
    }

    public String getColonia() {
        return Colonia;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCP() {
        return CP;
    }

    public String getLicencia() {
        return Licencia;
    }

    public String getGenero() {
        return Genero;
    }

    public int getEdad() {
        return Edad;
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

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
  
}