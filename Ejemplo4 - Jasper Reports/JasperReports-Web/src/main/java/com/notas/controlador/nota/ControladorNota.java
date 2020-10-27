package com.notas.controlador.nota;

import com.notas.modelo.NotaModel;
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
@WebServlet("/ControladorNota")
public class ControladorNota extends HttpServlet {

    NotaModel notaModel = new NotaModel();
    UsuarioModel usuarioModel = new UsuarioModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idUsuario = request.getParameter("usuario");
            if (idUsuario != null) {
                Usuario usuario = usuarioModel.obtenerUsuario(Integer.parseInt(idUsuario));
                if (usuario != null) {
                    request.setAttribute("nombre", usuario.getNombre());
                    request.setAttribute("profesion", usuario.getProfesion());
                    request.setAttribute("notas", notaModel.notasDeUsuario(Integer.parseInt(idUsuario)));
                    request.getRequestDispatcher("/nota/userNotes.jsp").forward(request, response);
                }
            }
        } catch (IOException | NumberFormatException  | ServletException e) {
            System.out.println("Error Notas: " + e.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error DB Notas: " + ex.getMessage());
        }

    }
}
