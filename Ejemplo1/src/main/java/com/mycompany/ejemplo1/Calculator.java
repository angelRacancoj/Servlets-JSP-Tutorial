package com.mycompany.ejemplo1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author orlan
 */
@WebServlet("/Calc")
public class Calculator extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int a1 = Integer.parseInt(request.getParameter("n1"));
        int a2 = Integer.parseInt(request.getParameter("n2"));
        if (request.getParameter("suma") != null) {
            out.println("<h1>Suma</h1>" + (a1 + a2));
        }
        if (request.getParameter("resta") != null) {
            out.println("<h1>Resta</h1>" + (a1 - a2));
        }
        if (request.getParameter("mult") != null) {
            out.println("<h1>Multiplicacion</h1>" + (a1 * a2));
        }
        if (request.getParameter("div") != null) {
            out.println("<h1>Division</h1>" + (a1 / a2));
        }
    }
}
