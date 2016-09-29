
package utng.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dao.AlumnoDAOImp;
import utng.model.Alumno;
import utng.dao.AlumnoDAO;

/**
 *
 * @author Guillermo juarez jaramillo
 */
public class AlumnoController extends HttpServlet{
    private static final String LISTA_ALUMNOS = "/listarAlumno.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/alumno.jsp";
    private AlumnoDAO dao;
    
    public AlumnoController() {
        dao = new AlumnoDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_ALUMNOS;
            int id = Integer.parseInt(request.getParameter("id"));
            dao.borrarAlumno(id);
            request.setAttribute("alumnos", dao.desplegarAlumno());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int id = Integer.parseInt(request.getParameter("id"));
            Alumno alumno = dao.elegirAlumno(id);
            request.setAttribute("alumno", alumno);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_ALUMNOS;
            request.setAttribute("alumnos", dao.desplegarAlumno());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Alumno alumno = new Alumno();
        String id = request.getParameter("id");
       alumno.setFecha_recep(request.getParameter("fecha_recep"));
        alumno.setFecha_devo(request.getParameter("fecha_devo"));
        alumno.setNota(request.getParameter("nota"));
        alumno.setDocumentacion(request.getParameter("documentacion"));
        if (id == null || id.isEmpty()) {
            dao.agregarAlumno(alumno);
            
        } else {
            alumno.setId(Integer.parseInt(id));
            dao.cambiarAlumno(alumno);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_ALUMNOS);
        request.setAttribute("alumnos", dao.desplegarAlumno());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
