<%-- 
    Document   : listarAlumno
    Created on : 22-sep-2016, 20:38:46
    Author     : Guillermo juarez jaramillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Alumnos</title>
    </head>
    <body>
         <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>fechaRecepcion</th>
                    <th>fechaDevolucion</th>
                    <th>nota</th>
                    <th>documentacion</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="alumno" items="${alumnos}">
                    <tr>
                        <td>${alumno.id}</td>
                        <td>${alumno.fecha_recep}</td>
                        <td>${alumno.fecha_devo}</td>
                        <td>${alumno.nota}</td>
                        <td>${alumno.documentacion}</td>
                        <td><a href="AlumnoController?action=cambiar&id=${alumno.id}">Cambiar</a></td>
                        <td><a href="AlumnoController?action=borrar&id=${alumno.id}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="AlumnoController?action=agregar">Nuevo Alumno</a>
        </p>
    </body>
</html>
