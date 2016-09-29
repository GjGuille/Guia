<%-- 
    Document   : usuarios
    Created on : 19-sep-2016, 21:54:38
    Author     : Guillermo juarez jaramillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar usuarios</title>
    </head>
    <body>
        <form action="UsuarioController" method="post">
            <fieldset>
                <div>
                    <label>id de usuario: </label>
                    <input type="text" name="idUsuario" value="${usuario.idUsuario}"
                           placeholder="idUsuario"
                           readonly="readonly"/>
                </div>
                <div>
                    <label>Login: </label>
                    <input type="text" name="login" value="${usuario.login}"
                           placeholder="Login"/>
                </div>
                <div>       
                    <label>Password: </label>
                    <input type="password" name="password" value="${usuario.password}"
                           placeholder="Password"/>
                </div>
                <div>
                    <label>Nombre: </label>
                    <input type="text" name="nombre" value="${usuario.nombre}"
                           placeholder="Nombre del usuario"/>
                </div>
                <div>
                    <label>Edad: </label>
                    <input type="text" name="edad" value="${usuario.edad}"
                           placeholder="Edad del usuario"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
