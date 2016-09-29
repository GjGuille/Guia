/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dao.ServicioDAO;
import utng.dao.ServicioDAOImp;
import utng.model.Servicio;

/**
 *
 * @author Guillermo
 */
public class ServicioController extends HttpServlet {
     private static final String LISTA_SERVICIOS = "/listarServicios.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/servicios.jsp";
    private ServicioDAO dao;
    
    public ServicioController() {
        dao = new ServicioDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_SERVICIOS;
            int id_servicio = Integer.parseInt(request.getParameter("id_servicio"));
            dao.borrarServicio(id_servicio);
            request.setAttribute("servicios", dao.desplegarServicio());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int id_servicio = Integer.parseInt(request.getParameter("id_servicio"));
            Servicio servicio = dao.elegirServicio(id_servicio);
            request.setAttribute("servicio", servicio);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_SERVICIOS;
            request.setAttribute("servicios", dao.desplegarServicio());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Servicio servicio = new Servicio();
        String id_servicio = request.getParameter("id_servicio");
       servicio.setNombre(request.getParameter("nombre"));
        servicio.setPrecio(Integer.parseInt(request.getParameter("precio")));
        servicio.setDescripcion(request.getParameter("descripcion"));
        
        if (id_servicio == null || id_servicio.isEmpty()) {
            dao.agregarServicio(servicio);
            
        } else {
            servicio.setId_servicio(Integer.parseInt(id_servicio));
            dao.cambiarServicio(servicio);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_SERVICIOS);
        request.setAttribute("servicios", dao.desplegarServicio());
        view.forward(request, response);
    }
    
   
    
    
}
