<%-- 
    Document   : servicios
    Created on : 29/09/2016, 08:59:18 AM
    Author     : Guillermo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
    </head>
    <body>
        <form action="ServicioController" method="post">
            <fieldset>
                <div>
                    <label>ID Servicio: </label>
                    <input type="text" name="id_servicio" value="${servicio.id_servicio}"
                           placeholder="id de Servicio" readonly="readonly"/>
                </div>
                <div>
                    <label>Nombre Servicio: </label>
                    <input type="text" name="nombre" value="${servicio.nombre}"
                           placeholder="nombre de servicio"/>
                </div>

                <div>
                    <label>Precio de servicio: </label>
                    <input type="text" name="precio" value="${servicio.precio}"
                           placeholder="precio de servicio"/>
                </div>
                <div>
                    <label>Descripcion: </label>
                    <input type="text" name="descripcion" value="${servicio.descripcion}"
                           placeholder="Descripcion Servicio"/>
                </div>
               
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
