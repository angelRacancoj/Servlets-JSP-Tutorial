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
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println("<!DOCTYTE html>");
      out.println("<html>");
      out.println("<head><title>Formulario GET</title></head>");
      out.println("<body>");
      out.println("<h1>Usando Metodo GET</h1>");
      out.println("<li><b>Nombre:</b>"+request.getParameter("first_name"));
      out.println("<li><b>Apellido:</b>"+ request.getParameter("last_name"));
      out.println("</ul>");
      out.println("</body>");
      out.println("</html>");
      
      out.close();
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println("<!DOCTYTE html>");
      out.println("<html>");
      out.println("<head><title>Formulario Post</title></head>");
      out.println("<body>");
      out.println("<h1>Usando Metodo Post</h1>");
      out.println("<li><b>Nombre:</b>"+request.getParameter("first_name"));
      out.println("<li><b>Apellido:</b>"+ request.getParameter("last_name"));
      out.println("</ul>");
      out.println("</body>");
      out.println("</html>");
      
      out.close();
    }
}
