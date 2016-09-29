/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Servicio;
import utng.util.UtilDB;

/**
 *
 * @author Guillermo
 */
public class ServicioDAOImp implements ServicioDAO{
    private Connection connection;
  
  public ServicioDAOImp(){
      connection=UtilDB.getConnection();
  }
    @Override
    public void agregarServicio(Servicio servicio) {
        try {
                String query = "INSERT INTO servicios ( \"nombre\", \"precio\", descripcion\n" +
"	VALUES ( ?, ?, ?)";
            PreparedStatement co = connection.prepareStatement(query);
           
            co.setString(1, servicio.getNombre());
            co.setInt(2, servicio.getPrecio());
            co.setString(3, servicio.getDescripcion());
            
            
            co.executeUpdate();
            //co.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarServicio(int idServicio) {
        try{
            String query = "DELETE FROM servicios WHERE "
                    + " id_servicio=?";
            PreparedStatement co = connection.prepareStatement(query);
            int id_servicio = 0;
            co.setInt(1, id_servicio);
            co.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarServicio(Servicio servicio) {
        try{
            String query = "UPDATE servicios SET nombre=?"
                    + ", precio=?"
                    + ", descripcion=?"
                    + "WHERE id_servicio=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setString(1, servicio.getNombre());
            co.setInt(2, servicio.getPrecio());
            co.setString(3, servicio.getDescripcion());
             co.setInt(4, servicio.getId_servicio());
            co.executeUpdate();
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    

    @Override
    public List<Servicio> desplegarServicio() {
        List<Servicio> servicios = new ArrayList<Servicio>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM servicios");
            while(rs.next()){
               Servicio servicio= new Servicio(rs.getInt("idServicio"),
                rs.getString("nombre"),
                rs.getInt("precio"),
                rs.getString("descripcion"));
                
                servicios.add(servicio);
            }
            rs.close();
            statement.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return servicios;
    }


    @Override
    public Servicio elegirServicio(int idServicio) {
        Servicio servicio=null;
        try{
            String query = " SELECT * FROM servicios WHERE id_servicio=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idServicio);
            ResultSet rs= statement.executeQuery();
            
            if(rs.next()){
                servicio= new Servicio(
                rs.getInt("idServicio"),
                rs.getString("nombre"),
                rs.getInt("precio"),
                rs.getString("descripcion"));
               }
            rs.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return servicio;
    }


   
    
}
