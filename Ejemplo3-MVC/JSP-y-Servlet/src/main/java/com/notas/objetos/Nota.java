package com.notas.objetos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author orlan
 */
public class Nota implements Serializable {

    public static final String NOTA_DB_NAME = "NOTA";
    public static final String NOTA_ID_DB_NAME = "idNota";
    public static final String INFORMACION_DB_NAME = "informacion";
    public static final String FECHA_DB_NAME = "fecha";
    public static final String ID_USUARIO_DB_NAME = "USUARIO_idUsuario";
    
    private int idNota;
    private String informacion;
    private LocalDate fecha;
    private int idUsuario;

    public Nota() {
    }

    public Nota(int idNota, String informacion, LocalDate fecha, int idUsuario) {
        this.idNota = idNota;
        this.informacion = informacion;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
