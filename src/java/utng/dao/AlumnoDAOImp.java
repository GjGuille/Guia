
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Alumno;
import utng.util.UtilDB;

/**
 *
 * @author Guillermo Juarez jaramillo 
 */
public class AlumnoDAOImp implements AlumnoDAO{
  private Connection connection;
  
  public AlumnoDAOImp(){
      connection=UtilDB.getConnection();
  }
    @Override
    public void agregarAlumno(Alumno alumno) {
        try {
                String query = "INSERT INTO alumno ( \"fecha_recep\", \"fecha_devo\", nota, documentacion)\n" +
"	VALUES ( ?, ?, ?, ?)";
            PreparedStatement co = connection.prepareStatement(query);
           
            co.setString(1, alumno.getFecha_recep());
            co.setString(2, alumno.getFecha_devo());
            co.setString(3, alumno.getNota());
            co.setString(4, alumno.getDocumentacion());
            
            co.executeUpdate();
            //co.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarAlumno(int id) {
        try{
            String query = "DELETE FROM alumno WHERE "
                    + " id=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setInt(1, id);
            co.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarAlumno(Alumno alumno) {
        try{
            String query = "UPDATE alumno SET fecha_recep=?"
                    + ", fecha_devo=?"
                    + ", nota=?"
                    + ",documentacion = ?"
                    + "WHERE id=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setString(1, alumno.getFecha_recep());
            co.setString(2, alumno.getFecha_devo());
            co.setString(3, alumno.getNota());
            co.setString(4, alumno.getDocumentacion());
             co.setInt(5, alumno.getId());
            co.executeUpdate();
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    

    @Override
    public List<Alumno> desplegarAlumno() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM alumno");
            while(rs.next()){
               Alumno alumno= new Alumno(rs.getInt("id"),
                rs.getString("fecha_recep"),
                rs.getString("fecha_devo"),
                rs.getString("nota"),
                rs.getString("documentacion"));
                alumnos.add(alumno);
            }
            rs.close();
            statement.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return alumnos;
    }

    @Override
    public Alumno elegirAlumno(int id) {
        Alumno alumno=null;
        try{
            String query = " SELECT * FROM alumno WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs= statement.executeQuery();
            
            if(rs.next()){
                alumno= new Alumno(
                rs.getInt("id"),
                rs.getString("fecha_recep"),
                rs.getString("fecha_devo"),
                rs.getString("nota"),
                rs.getString("documentacion"));
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return alumno;
    }
    
}
