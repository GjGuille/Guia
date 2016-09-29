<%-- 
    Document   : listarServicios
    Created on : 29/09/2016, 09:07:18 AM
    Author     : Guillermo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Servicios</title>
    </head>
    <body>
         <table>
            <thead>
                <tr>
                    <th>id_servicio</th>
                    <th>nombre</th>
                    <th>precio</th>
                    <th>descripcion</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="servicios" items="${servicios}">
                    <tr>
                        <td>${servicio.id_servicio}</td>
                        <td>${servicio.nombre}</td>
                        <td>${servicio.precio}</td>
                        <td>${servicio.descripcion}</td>
                        
                        <td><a href="ServicioController?action=cambiar&id_servicio=${servicio.id_servicio}">Cambiar</a></td>
                        <td><a href="ServicioController?action=borrar&id_servicio=${servicio.id_servicio}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ServicioController?action=agregar">Nuevo Servicio</a>
        </p>
    </body>
</html>
