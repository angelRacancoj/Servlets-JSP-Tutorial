package com.notas.modelo;

import com.notas.objetos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author orlan
 */
public class UsuarioModel {

    private final String USUARIOS = "SELECT * FROM " + Usuario.USUARIO_DB_NAME;
    private final String BUSCAR_USUARIO = USUARIOS + " WHERE " + Usuario.USUARIO_ID_DB_NAME + " = ? LIMIT 1";
    private final String USUARIOS_POR_NOMBRE = USUARIOS + " WHERE " + Usuario.NOMBRE_DB_NAME + " LIKE ?";
    private final String CREAR_USUARIO = "INSERT INTO " + Usuario.USUARIO_DB_NAME + " (" + Usuario.NOMBRE_DB_NAME + "," + Usuario.PROFESION_DB_NAME + "," + Usuario.PASSWORD_DB_NAME + ") VALUES (?,?,?)";

    private static Connection connection = ConnectionDB.getInstance();

    /**
     * Agregamos una nuevo usuario. Al completar la insercion devuelve el ID
     * autogenerado del usuario. De no existir nos devolvera <code>-1</code>.
     *
     * @param usuario
     * @return
     * @throws SQLException
     */
    public long agregarUsuario(Usuario usuario) throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(CREAR_USUARIO, Statement.RETURN_GENERATED_KEYS);

        preSt.setString(1, usuario.getNombre());
        preSt.setString(2, usuario.getProfesion());
        preSt.setString(3, usuario.getPassword());

        preSt.executeUpdate();

        ResultSet result = preSt.getGeneratedKeys();
        if (result.first()) {
            return result.getLong(1);
        }

        return -1;
    }

    /**
     * Obtenemos todas los usuarios almacenados en la base de datos.
     *
     * @return
     * @throws SQLException
     */
    public List<Usuario> todosLosUsuarios() throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(USUARIOS);
        ResultSet result = preSt.executeQuery();

        List<Usuario> usuario = new LinkedList<>();

        while (result.next()) {
            usuario.add(new Usuario(
                    result.getInt(Usuario.USUARIO_ID_DB_NAME),
                    result.getString(Usuario.NOMBRE_DB_NAME),
                    result.getString(Usuario.PROFESION_DB_NAME),
                    result.getString(Usuario.PASSWORD_DB_NAME)
            ));
        }
        System.out.println("Usuarios: " + usuario.size());
        return usuario;
    }

    /**
     * Realizamos una busqueda en base al id del usuario. De no existir la nota
     * nos devuelve un valor null.
     *
     * @param idUsuario
     * @return
     * @throws SQLException
     */
    public Usuario obtenerUsuario(int idUsuario) throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_USUARIO);
        preSt.setInt(1, idUsuario);
        ResultSet result = preSt.executeQuery();

        Usuario usuario = null;

        while (result.next()) {
            usuario = new Usuario(
                    result.getInt(Usuario.USUARIO_ID_DB_NAME),
                    result.getString(Usuario.NOMBRE_DB_NAME),
                    result.getString(Usuario.PROFESION_DB_NAME),
                    result.getString(Usuario.PASSWORD_DB_NAME)
            );
        }
        return usuario;
    }

    /**
     * Realiza una busqueda de los usuarios en base al nombre con los caracteres
     * consecutivos similares utilizando el comando <code>LIKE</code>. De no
     * existir resultado devolvera una lista vacia.
     *
     * @param nombre
     * @return
     * @throws SQLException
     */
    public List<Usuario> buscarPorNombre(String nombre) throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(USUARIOS_POR_NOMBRE);
        preSt.setString(1, "%" + nombre + "%");
        ResultSet result = preSt.executeQuery();

        List<Usuario> usuario = new LinkedList<>();

        while (result.next()) {
            usuario.add(new Usuario(
                    result.getInt(Usuario.USUARIO_ID_DB_NAME),
                    result.getString(Usuario.NOMBRE_DB_NAME),
                    result.getString(Usuario.PROFESION_DB_NAME),
                    result.getString(Usuario.PASSWORD_DB_NAME)
            ));
        }
        System.out.println("Usuarios: " + usuario.size());
        return usuario;
    }

    /**
     * Verify if User exist and has the correct credentials
     *
     * @param id
     * @param pass
     * @return
     * @throws SQLException
     */
    public Usuario loginValidation(int id, String pass) throws SQLException {
        Usuario user = obtenerUsuario(id);
        if (user != null && user.getPassword().equals(pass)) {
            return user;
        }
        return null;
    }
}
