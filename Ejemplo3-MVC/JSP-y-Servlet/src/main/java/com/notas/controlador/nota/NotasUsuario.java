package com.notas.controlador.nota;

import com.notas.modelo.NotaModel;
import com.notas.modelo.UsuarioModel;
import com.notas.objetos.Nota;
import com.notas.objetos.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author orlan
 */
@WebServlet("/NotasUsuario")
public class NotasUsuario extends HttpServlet {

    UsuarioModel usuarioModel = new UsuarioModel();
    NotaModel notaModel = new NotaModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            if (request.getSession().getAttribute("id") == null) {
                response.sendRedirect(request.getContextPath() + "/Login");
            }

            System.out.println("ID user: " + ((String) request.getSession().getAttribute("id")));
            Usuario usuario = usuarioModel.obtenerUsuario(Integer.parseInt((String) request.getSession().getAttribute("id")));

            request.setAttribute("notas", notaModel.notasDeUsuario(usuario.getIdUsuario()));
            request.setAttribute("nombre", usuario.getNombre());

            request.getRequestDispatcher("/nota/misNotas.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            if (request.getSession().getAttribute("id") == null) {
                response.sendRedirect(request.getContextPath() + "/Login");
            }

            System.out.println("ID user: " + ((String) request.getSession().getAttribute("id")));
            Usuario usuario = usuarioModel.obtenerUsuario(Integer.parseInt((String) request.getSession().getAttribute("id")));

            String nota = request.getParameter("nueva");
            
            notaModel.agregarNota(new Nota(0, nota, LocalDate.now(), usuario.getIdUsuario()));
            response.sendRedirect(request.getContextPath()+"/NotasUsuario");

        } catch (IOException | NumberFormatException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
