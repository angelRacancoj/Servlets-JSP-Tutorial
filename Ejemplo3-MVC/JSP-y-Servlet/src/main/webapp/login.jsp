<%-- 
    Document   : login
    Created on : 1/10/2020, 04:50:45 PM
    Author     : orlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            #error {
                color: red;
            }
        </style>
    </head>
    <body>
        <c:if test="${success == 0}">
            <p id="error">Usuario o Contraseña Incorrecto</p>
        </c:if>
        <h1>Ingreso</h1>
        <form action="Login" method="POST">
            <p>ID: <input type="text" name="id"/> </p>
            <p>Contraseña: <input type="password" name="pass"/> </p>
            <input type="submit" name="Ingresar"/>
        </form>
    </body>
</html>
