<%-- 
    Document   : guia
    Created on : 29/09/2016, 02:31:10 PM
    Author     : Guillermo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guia</title>
    </head>
    <body>
        <form action="GuiaController" method="post">
            <fieldset>
                <div>
                    <label>ID de Guia: </label>
                    <input type="text" name="idGuia" value="${guia.idGuia}"
                           placeholder="idGuia" readonly="readonly"/>
                </div>
                <div>
                    <label>Nombre de Guia: </label>
                    <input type="text" name="nombre" value="${guia.nombre}"
                           placeholder="nombre"/>
                </div>

                <div>
                    <label>Direccion del Guia: </label>
                    <input type="text" name="direccion" value="${guia.direccion}"
                           placeholder="direccion"/>
                </div>
                <div>
                    <label>Telefono: </label>
                    <input type="text" name="telefono" value="${guia.telefono}"
                           placeholder="telefono"/>
                </div>
                <div>       
                    <label>Email de Guia: </label>
                    <input type="text" name="email" value="${guia.email}"
                           placeholder="email"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
