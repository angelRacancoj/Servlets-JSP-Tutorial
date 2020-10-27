package com.notas.controlador.nota;

import com.notas.modelo.NotaModel;
import com.notas.modelo.UsuarioModel;
import com.notas.objetos.Nota;
import com.notas.objetos.Usuario;
import com.sun.javafx.util.Utils;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author orlan
 */
@WebServlet("/notasPDF")
public class ExportarNotas extends HttpServlet {

    UsuarioModel usuarioModel = new UsuarioModel();
    NotaModel notaModel = new NotaModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {

            if (request.getSession().getAttribute("id") == null) {
                response.sendRedirect(request.getContextPath() + "/Login");
            }
            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=misNotas.pdf");

            System.out.println("ID user: " + ((String) request.getSession().getAttribute("id")));
            Usuario usuario = usuarioModel.obtenerUsuario(Integer.parseInt((String) request.getSession().getAttribute("id")));

            List<Nota> notasUsuario = notaModel.notasDeUsuario(usuario.getIdUsuario());

            File file = new File(request.getServletContext().getRealPath("/resources/mis_notas.jrxml"));
//            File file = new File(Thread.currentThread().getContextClassLoader().getResource("resources/mis_notas.jrxml").getFile());
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(notasUsuario);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", "Angel");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReports, parameters, dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            response.getOutputStream().flush();
            response.getOutputStream().close();
            
        } catch (IOException | NumberFormatException | SQLException  e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
}
