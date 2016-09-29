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
import utng.dao.GuiaDAO;
import utng.dao.GuiaDAOImp;
import utng.model.Guia;

/**
 *
 * @author Guillermo
 */
public class GuiaController extends HttpServlet{
    private static final String LISTA_GUIAS = "/listarGuias.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/guia.jsp";
    private GuiaDAO dao;
    
    public GuiaController() {
        dao = new GuiaDAOImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_GUIAS;
            int idGuia = Integer.parseInt(request.getParameter("idGuia"));
            dao.borrarGuia(idGuia);
            request.setAttribute("guias", dao.desplegarGuia());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idGuia = Integer.parseInt(request.getParameter("idGuia"));
            Guia guia = dao.elegirGuia(idGuia);
            request.setAttribute("guia", guia);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_GUIAS;
            request.setAttribute("guias", dao.desplegarGuia());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Guia guia = new Guia();
        String idGuia = request.getParameter("idGuia");
       guia.setNombre(request.getParameter("nombre"));
        guia.setDireccion(request.getParameter("direccion"));
        guia.setTelefono(request.getParameter("telefono"));
        guia.setEmail(request.getParameter("email"));
        if (idGuia == null || idGuia.isEmpty()) {
            dao.agregarGuia(guia);
            
        } else {
            guia.setIdGuia(Integer.parseInt(idGuia));
            dao.cambiarGuia(guia);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_GUIAS);
        request.setAttribute("guias", dao.desplegarGuia());
        view.forward(request, response);
    }
    
      @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
