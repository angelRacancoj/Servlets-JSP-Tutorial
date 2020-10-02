<%-- 
    Document   : misNotas
    Created on : 1/10/2020, 04:55:59 PM
    Author     : orlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Notas</title>
    </head>
    <body>
        <%@ include file = "../menu.jsp" %>
        <h1>Mis Notas</h1>
        <form method="POST" action="NotasUsuario">
            <p><b>Nueva Nota</b> <input type="text" name="nueva"/></p>
            <input type="submit" value="Agregar"/>
        </form>

        <h3>Notas de ${nombre}</h3>
        <table>
            <tr>
                <th>Codigo</th>
                <th>Informacion</th>
                <th>Fecha</th>
            </tr>
            <c:forEach items="${notas}" var="nota">
                <tr>
                    <td>${nota.idNota}</td>
                    <td>${nota.informacion}</td>
                    <td>${nota.fecha}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
