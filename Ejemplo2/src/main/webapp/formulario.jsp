<%-- 
    Document   : formulario
    Created on : 24/09/2020, 03:40:49 AM
    Author     : orlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<HTML>     
    <%@ include file = "Header.html" %>     
    <BODY> 
        <%-- utilizaremos una estructura IF para tener una pagina dinamica--%>
        <%-- UTILIZAMOS SCRIPTLET--%>
        <% if (request.getParameter("name")
            == null && request.getParameter("email")
            == null) { %>     
    <CENTER>     
        <H2>Formulario (<%= LocalDate.now()%>)</H2>     
        <FORM METHOD="GET" ACTION="formulario.jsp">     
            <P>     
                Nombre: <input type="text" name="name">     
            <P>     
                Correo Electronico: <input type="text" name="email">     
            <P>     
                <input type="submit" value="Enviar">     
        </FORM>     
    </CENTER>     
    <% } else { %>
    <%-- Declaramos nuestra variables String--%>
    <%! String name, email;%>     
    <%
        name = request.getParameter("name");
        email = request.getParameter("email");
    %>     
    <P>     
        <B>Tu informacion es:</B>:     
    <P>     
        <%-- Utilizamos Expresiones para mostrar los datos --%>
        <B>Nombre:</B>: <%= name%><P>     
        <B>Correo:</B>: <%= email%>     
            <% }%>     
    </BODY>     
</HTML>     
