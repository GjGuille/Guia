
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Usuario;
import utng.util.UtilDB;

/**
 *
 * @author Guillermo juarez jaramillo
 */
public class UsuarioDAOImp implements UsuarioDAO {
    
    private Connection connection;
    
    public UsuarioDAOImp() {
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarUsuario(Usuario usuario) {
        try {
            String query = "INSERT INTO usuarios(login,password, nombre,edad)" + "VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombre());
            ps.setInt(4, usuario.getEdad());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void borrarUsuario(int idUsuario) {
        try {
            String query = "DELETE FROM usuarios WHERE "
                    + " id_usuario=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void cambiarUsuario(Usuario usuario) {
        try {
            String query = "UPDATE usuarios SET login= ?"
                    + ", password=?"
                    + ", nombre=?"
                    + ", edad=?"
                    + "WHERE id_usuario=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombre());
            ps.setInt(4, usuario.getEdad());
            ps.setInt(5, usuario.getIdUsuario());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Usuario> desplegarUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id_usuario"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getInt("edad"));
                usuarios.add(usuario);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    @Override
    public Usuario elegirUsuario(int idUsuario) {
        Usuario usuario=null;
        try {
            String query = " SELECT * FROM usuarios WHERE id_usuario=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idUsuario);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                  usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("nombre"),
                        rs.getInt("edad"));
             
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    
}//FIN DE LA CLASE
