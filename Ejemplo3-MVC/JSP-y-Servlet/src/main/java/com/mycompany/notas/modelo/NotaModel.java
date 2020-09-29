package com.mycompany.notas.modelo;

import com.mycompany.notas.objetos.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author orlan
 */
public class NotaModel {

    private final String BUSCAR_NOTA = "SELECT * FROM " + Nota.NOTA_DB_NAME + " WHERE " + Nota.NOTA_ID_DB_NAME + " = ?";
    private final String TODAS_LAS_NOTA = "SELECT * FROM " + Nota.NOTA_DB_NAME;
    private final String NOTAS_USUARIO = "SELECT * FROM " + Nota.NOTA_DB_NAME + " WHERE " + Nota.ID_USUARIO_DB_NAME + " = ?";
    private final String CREAR_NOTA = "INSERT INTO " + Nota.NOTA_DB_NAME + " (" + Nota.INFORMACION_DB_NAME + "," + Nota.FECHA_DB_NAME + "," + Nota.ID_USUARIO_DB_NAME + ")";

    private static Connection connection = ConnectionDB.getInstance();

    /**
     * Agregamos una nueva nota, debe existir previamente un <b>USUARIO</b>
     * registrado. Al completar la insercion devuelve el ID autogenerado de la
     * nota. De no existir nos devolvera <code>-1</code>.
     *
     * @param nota
     * @return
     * @throws SQLException
     */
    public long agregarNota(Nota nota) throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(CREAR_NOTA, Statement.RETURN_GENERATED_KEYS);

        preSt.setString(1, nota.getInformacion());
        preSt.setString(2, nota.getFecha().toString());
        preSt.setInt(3, nota.getIdUsuario());

        preSt.executeUpdate();

        ResultSet result = preSt.getGeneratedKeys();
        if (result.first()) {
            return result.getLong(1);
        }

        return -1;
    }

    /**
     * Realizamos una busqueda en base al idNota. De no existir la nota nos
     * devuelve un valor null.
     *
     * @param idNota
     * @return
     * @throws SQLException
     */
    public Nota buscarNota(int idNota) throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(BUSCAR_NOTA);
        preSt.setString(1, String.valueOf(idNota));
        ResultSet result = preSt.executeQuery();

        while (result.first()) {
            return new Nota(
                    result.getInt(Nota.NOTA_ID_DB_NAME),
                    result.getString(Nota.INFORMACION_DB_NAME),
                    LocalDate.parse(result.getString(Nota.FECHA_DB_NAME)),
                    result.getInt(Nota.ID_USUARIO_DB_NAME)
            );
        }
        return null;
    }

    /**
     * Utilizamos el ID del usuario para identificar sus notas almacenadas. De
     * no existir notas el listado se devolvera vacio.
     *
     * @param idUsuario
     * @return
     * @throws SQLException
     */
    public List<Nota> notasDeUsuario(int idUsuario) throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(NOTAS_USUARIO);
        preSt.setString(1, String.valueOf(idUsuario));
        ResultSet result = preSt.executeQuery();

        List<Nota> notas = new LinkedList<>();

        while (result.next()) {
            notas.add(new Nota(
                    result.getInt(Nota.NOTA_ID_DB_NAME),
                    result.getString(Nota.INFORMACION_DB_NAME),
                    LocalDate.parse(result.getString(Nota.FECHA_DB_NAME)),
                    result.getInt(Nota.ID_USUARIO_DB_NAME)
            ));
        }
        return notas;
    }

    /**
     * Obtenemos todas las notas almacenadas en la base de datos.
     *
     * @return
     * @throws SQLException
     */
    public List<Nota> todasLasNotas() throws SQLException {
        PreparedStatement preSt = connection.prepareStatement(TODAS_LAS_NOTA);
        ResultSet result = preSt.executeQuery();

        List<Nota> notas = new LinkedList<>();

        while (result.next()) {
            notas.add(new Nota(
                    result.getInt(Nota.NOTA_ID_DB_NAME),
                    result.getString(Nota.INFORMACION_DB_NAME),
                    LocalDate.parse(result.getString(Nota.FECHA_DB_NAME)),
                    result.getInt(Nota.ID_USUARIO_DB_NAME)
            ));
        }
        return notas;
    }

}
