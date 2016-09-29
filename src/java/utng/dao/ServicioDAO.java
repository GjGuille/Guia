/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.Servicio;

/**
 *
 * @author Guillermo
 */
public interface ServicioDAO {
     void agregarServicio(Servicio servicio);
    void borrarServicio(int id_servicio);
    void cambiarServicio(Servicio servicio);
    List<Servicio> desplegarServicio();
    Servicio elegirServicio(int id_servicio);
    
}
