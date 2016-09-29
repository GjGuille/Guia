
package utng.model;

/**
 *
 * @author Guillermo juarez jaramillo 
 */
public class Alumno {
    private int id;
    private String fecha_recep;
    private String fecha_devo;
    private String nota;
    private String documentacion;

    public Alumno(int id, String fecha_recep, String fecha_devo, String nota, String documentacion) {
        this.id = id;
        this.fecha_recep = fecha_recep;
        this.fecha_devo = fecha_devo;
        this.nota = nota;
        this.documentacion = documentacion;
    }
    
    public Alumno(){
        this(0,"","","","");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_recep() {
        return fecha_recep;
    }

    public void setFecha_recep(String fecha_recep) {
        this.fecha_recep = fecha_recep;
    }

    public String getFecha_devo() {
        return fecha_devo;
    }

    public void setFecha_devo(String fecha_devo) {
        this.fecha_devo = fecha_devo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

   

   

    @Override
    public String toString() {
        return "alumno{" + "id=" + id + ", fechaRecep=" + fecha_recep + ", fechaDevo=" + fecha_devo + ", nota=" + nota + ", documentacion=" + documentacion + '}';
    }
    
    
    
}
