
package utng.dao;

import java.util.List;
import utng.model.Alumno;

/**
 *
 * @author Guillermo Juarez jaramillo
 */
public interface AlumnoDAO {
    void agregarAlumno(Alumno alumno);
    void borrarAlumno(int id);
    void cambiarAlumno(Alumno alumno);
    List<Alumno> desplegarAlumno();
    Alumno elegirAlumno(int id);
}
