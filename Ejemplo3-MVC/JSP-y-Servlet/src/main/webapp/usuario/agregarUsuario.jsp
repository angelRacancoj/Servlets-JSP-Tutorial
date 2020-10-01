<%-- 
    Document   : agregarUsuario
    Created on : 29/09/2020, 10:40:22 PM
    Author     : orlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <%@ include file = "../menu.jsp" %>
        <h1>Nuevo Usuario</h1>
        <form Method="POST" action="../ControladorUsuario">
            <p> Nombre: <input type="text" name="nombre"></p>
            <p> Profesion: <input type="text" name="profesion"></p>
            <p> Password: <input type="password" name="pass"></p>
            <input type="submit" value="Agregar"> 
        </form>
    </body>
</html>
