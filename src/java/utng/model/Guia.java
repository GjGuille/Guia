/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

/**
 *
 * @author Guillermo
 */
public class Guia {

   
     private int idGuia;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    public Guia(int idGuia, String nombre, String direccion, String telefono, String email) {
        this.idGuia = idGuia;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    
    public Guia(){
        this(0,"","","","");
    }

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int id_guia) {
        this.idGuia = idGuia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
     @Override
    public String toString() {
        return "Guia{" + "idGuia=" + idGuia + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
}
