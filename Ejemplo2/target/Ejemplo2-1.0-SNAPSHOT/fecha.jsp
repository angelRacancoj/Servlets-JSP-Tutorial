<%-- 
    Document   : fecha
    Created on : 24/09/2020, 03:26:27 AM
    Author     : orlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>     
    <HEAD>     
        <TITLE>JSP Example</TITLE>     
    </HEAD>     
    <BODY>     
    <CENTER>     
        <H2>Fecha</H2>     
            <%
                java.time.LocalDate today = java.time.LocalDate.now();
                out.println("La fecha de hoy es: " + today);
            %>     
    </CENTER>     
</BODY>     
</HTML> 
