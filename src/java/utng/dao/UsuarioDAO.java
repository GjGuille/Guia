/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.Usuario;

/**
 *
 * @author Guillermo juarez jaramillo
 */
public interface UsuarioDAO {
    void agregarUsuario(Usuario usuario);
    void borrarUsuario(int idUsuario);
    void cambiarUsuario(Usuario usuario);
    List<Usuario> desplegarUsuarios();
    Usuario elegirUsuario(int idUsuario);
 }
