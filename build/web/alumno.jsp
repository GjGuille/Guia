<%-- 
    Document   : servicio
    Created on : 22-sep-2016, 20:32:51
    Author     : Guillermo Juraez jaramillo 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DoctoAlumno</title>
    </head>
    <body>
        <form action="AlumnoController" method="post">
            <fieldset>
                <div>
                    <label>ID de Alumno: </label>
                    <input type="text" name="id" value="${alumno.id}"
                           placeholder="id" readonly="readonly"/>
                </div>
                <div>
                    <label>fechaRecepcion: </label>
                    <input type="text" name="fecha_recep" value="${alumno.fecha_recep}"
                           placeholder="fechaRecep"/>
                </div>

                <div>
                    <label>fechaDevolucion: </label>
                    <input type="text" name="fecha_devo" value="${alumno.fecha_devo}"
                           placeholder="Fecha Devolucion"/>
                </div>
                <div>
                    <label>nota: </label>
                    <input type="text" name="nota" value="${alumno.nota}"
                           placeholder="Nota Alumno"/>
                </div>
                <div>       
                    <label>documentacion: </label>
                    <input type="text" name="documentacion" value="${alumno.documentacion}"
                           placeholder="Documentacion"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
