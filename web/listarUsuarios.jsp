<%-- 
    Document   : listarUsuarios
    Created on : 19-sep-2016, 21:54:26
    Author     : Guillermo juaramillo 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar usuarios</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id Usuario</th>
                    <th>Login</th>
                    <th>Password</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr>
                        <td>${usuario.idUsuario}</td>
                        <td>${usuario.login}</td>
                        <td>${usuario.password}</td>
                        <td>${usuario.nombre}</td>
                        <td>${usuario.edad}</td>
                        <td><a href="UsuarioController?action=cambiar&idUsuario=${usuario.idUsuario}">Cambiar</a></td>
                        <td><a href="UsuarioController?action=borrar&idUsuario=${usuario.idUsuario}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="UsuarioController?action=agregar">Nuevo usuario</a>
        </p>
    </body>
</html>
