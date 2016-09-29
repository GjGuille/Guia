/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.Guia;

/**
 *
 * @author Guillermo
 */
public interface GuiaDAO {
     void agregarGuia(Guia guia);
    void borrarGuia(int idGuia);
    void cambiarGuia(Guia guia);
    List<Guia> desplegarGuia();
    Guia elegirGuia(int idGuia);
}
