/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notas.controlador.usuario;

import com.notas.modelo.UsuarioModel;
import com.notas.objetos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author orlan
 */
@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet {

    UsuarioModel usuarioModel = new UsuarioModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("nombre");
            if (name == null || (name != null && name.isEmpty())) {
                request.setAttribute("usuarios", usuarioModel.todosLosUsuarios());
            } else {
                request.setAttribute("usuarios", usuarioModel.buscarPorNombre(name));
            }
            
            request.getRequestDispatcher("/usuario/usuarios.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("Error User: " + e.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nombre = request.getParameter("nombre");
            String profesion = request.getParameter("profesion");
            String pass = request.getParameter("pass");
            if (nombre != null && profesion != null && pass != null) {
                long id = usuarioModel.agregarUsuario(new Usuario(0, nombre, profesion, pass));
                System.out.println("New ID: " + id);
                response.sendRedirect(request.getContextPath()+"/ControladorUsuario");
            }
        } catch (IOException | SQLException  e) {
            System.out.println("Error User: " + e.getMessage());
        }

    }
}
