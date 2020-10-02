/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notas.controlador.usuario;

import com.notas.modelo.UsuarioModel;
import com.notas.objetos.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author orlan
 */
@WebServlet("/Login")
public class login extends HttpServlet {

    UsuarioModel usuarioModel = new UsuarioModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            System.out.println("Login Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            String pass = request.getParameter("pass");
            Usuario usuario = usuarioModel.loginValidation(Integer.parseInt(id), pass);
            if (usuario != null) {
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("profesion", usuario.getProfesion());
                response.sendRedirect(request.getContextPath() + "/NotasUsuario");
            } else {
                request.setAttribute("success", 0);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException | IOException | NumberFormatException e) {
            System.out.println("Login Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
