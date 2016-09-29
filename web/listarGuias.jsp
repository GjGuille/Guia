<%-- 
    Document   : listarGuias
    Created on : 29/09/2016, 02:31:30 PM
    Author     : Guillermo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Guias</title>
    </head>
    <body>
         <table>
            <thead>
                <tr>
                    <th>idGuia</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>telefono</th>
                    <th>email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="guia" items="${guias}">
                    <tr>
                        <td>${guia.idGuia}</td>
                        <td>${guia.nombre}</td>
                        <td>${guia.direccion}</td>
                        <td>${guia.telefono}</td>
                        <td>${guia.email}</td>
                        <td><a href="GuiaController?action=cambiar&idGuia=${guia.idGuia}">Cambiar</a></td>
                        <td><a href="GuiaController?action=borrar&idGuia=${guia.idGuia}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="GuiaController?action=agregar">Nuevo Guia</a>
        </p>
    </body>
</html>
