package com.notas.controlador.usuario;

import com.notas.modelo.UsuarioModel;
import com.notas.objetos.Usuario;
import com.notas.objetos.UsuarioCantNotas;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet("/usuariosPDF")
public class ExportarUsuarios extends HttpServlet {

    UsuarioModel usuarioModel = new UsuarioModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            if (request.getSession().getAttribute("id") == null) {
                response.sendRedirect(request.getContextPath() + "/Login");
            }

            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Usuarios.pdf");
            
            List<Usuario> usuarios = usuarioModel.buscarPorNombre("");
            
            File file = new File(request.getServletContext().getRealPath("/resources/Usuarios1.jrxml"));
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(usuarios);
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("nombre", "Angel");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReports, parameters, dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException | SQLException | JRException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            if (request.getSession().getAttribute("id") == null) {
                response.sendRedirect(request.getContextPath() + "/Login");
            }

            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Usuarios.pdf");
            
            List<UsuarioCantNotas> usuarios = usuarioModel.cantNotasUsuarios();
            
            File file = new File(request.getServletContext().getRealPath("/resources/usuarios.jrxml"));
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(usuarios);
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("Autor", "Angel");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReports, parameters, dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException | SQLException | JRException e) {
            e.printStackTrace();
        }
    }
}
