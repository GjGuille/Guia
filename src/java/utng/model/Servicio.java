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
public class Servicio {
    private int id_servicio;
    private String nombre;
    private int precio;
    private String descripcion;
    

    public Servicio(int idServico, String nombre, int precio, String descripcion) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        
    }
    
    public Servicio(){
        this(0,"",0,"");
    }

    public Servicio(int aInt, String string, int aInt0, String string0, boolean add) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     @Override
    public String toString() {
        return "servicios{" + "id_servicio=" + id_servicio + ", nombre=" + nombre + ", precio=" + precio + ", desripcion=" + descripcion+'}';
    }
    
    
}
