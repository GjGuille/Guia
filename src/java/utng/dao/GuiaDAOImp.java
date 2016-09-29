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
import utng.model.Guia;
import utng.util.UtilDB;

/**
 *
 * @author Guillermo
 */
public class GuiaDAOImp implements GuiaDAO{
    private Connection connection;
  
  public GuiaDAOImp(){
      connection=UtilDB.getConnection();
  }
    
  @Override
    public void agregarGuia(Guia guia) {
        try {
                String query = "INSERT INTO guias ( \"nombre\", \"direccion\", telefono, email)\n" +
"	VALUES ( ?, ?, ?, ?)";
            PreparedStatement co = connection.prepareStatement(query);
           
            co.setString(1, guia.getNombre());
            co.setString(2, guia.getDireccion());
            co.setString(3, guia.getTelefono());
            co.setString(4, guia.getEmail());
            
            co.executeUpdate();
            //co.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarGuia(int idGuia) {
        try{
            String query = "DELETE FROM guias WHERE "
                    + " idGuia=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setInt(1, idGuia);
            co.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarGuia(Guia guia) {
        try{
            String query = "UPDATE guias SET nombre=?"
                    + ", direccion=?"
                    + ", telefono=?"
                    + ",email = ?"
                    + "WHERE idGuia=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setString(1, guia.getNombre());
            co.setString(2, guia.getDireccion());
            co.setString(3, guia.getTelefono());
            co.setString(4, guia.getEmail());
             co.setInt(5, guia.getIdGuia());
            co.executeUpdate();
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    

    @Override
    public List<Guia> desplegarGuia() {
        List<Guia> guias = new ArrayList<Guia>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM guias");
            while(rs.next()){
               Guia guia= new Guia(rs.getInt("idGuia"),
                rs.getString("nombre"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getString("email"));
                guias.add(guia);
            }
            rs.close();
            statement.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return guias;
    }

    @Override
    public Guia elegirGuia(int idGuia) {
        Guia guia=null;
        try{
            String query = " SELECT * FROM guias WHERE idGuia=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idGuia);
            ResultSet rs= statement.executeQuery();
            
            if(rs.next()){
                guia= new Guia(
                rs.getInt("idGuia"),
                rs.getString("nombre"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getString("email"));
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return guia;
    }
    
}
