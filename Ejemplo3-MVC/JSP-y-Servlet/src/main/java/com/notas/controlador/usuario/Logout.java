package com.notas.controlador.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author orlan
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().removeAttribute("id");
        request.getSession().removeAttribute("profesion");
        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
