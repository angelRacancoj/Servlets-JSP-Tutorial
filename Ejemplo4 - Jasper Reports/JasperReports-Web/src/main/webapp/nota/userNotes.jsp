<%-- 
    Document   : userNotes
    Created on : 30/09/2020, 08:21:29 AM
    Author     : orlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notas</title>
    </head>
    <body>
        <%@ include file = "../menu.jsp" %>
        <h1>Notas de ${nombre} (${profesion})</h1>
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
