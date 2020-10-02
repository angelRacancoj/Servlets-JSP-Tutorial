<%-- 
    Document   : menu
    Created on : 29/09/2020, 11:03:14 PM
    Author     : orlan
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div style="padding: 5px;">

    <a href="${pageContext.request.contextPath}/ControladorUsuario">Ver Usuarios</a>
    |
    <a href="${pageContext.request.contextPath}/usuario/agregarUsuario.jsp">Nuevo Usuario</a>
    |
    <a href="${pageContext.request.contextPath}/NotasUsuario">Mis Notas</a>
    |
    <a href="${pageContext.request.contextPath}/Logout">Salir</a>

</div>  
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
    if (session.getAttribute("id") == null) {
        response.sendRedirect("Login");
    }
%>
