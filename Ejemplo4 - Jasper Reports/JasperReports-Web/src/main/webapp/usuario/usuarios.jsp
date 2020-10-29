<%-- 
    Document   : usuarios
    Created on : 29/09/2020, 04:20:24 PM
    Author     : orlan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Usuarios</title>
    </head>
    <body>
        <%@ include file = "../menu.jsp" %>
        <h1>Usuarios</h1>
        <form Method="GET" action="ControladorUsuario">
            <p>Nombre: <input type="text" name="nombre"/></p> 
            <input type="submit" value="Buscar"/> 
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Profesion</th>
                    <th>Notas</th>
                </tr>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td>${usuario.idUsuario}</td>
                        <td>${usuario.nombre}</td>
                        <td>${usuario.profesion}</td>
                        <td><a href="${pageContext.request.contextPath}/ControladorNota?usuario=${usuario.idUsuario}">Notas</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        
        <form method="GET" action="usuariosPDF">
            <input type="submit" value="Exportar Usuarios"/>
        </form>
    </body>
</html>
