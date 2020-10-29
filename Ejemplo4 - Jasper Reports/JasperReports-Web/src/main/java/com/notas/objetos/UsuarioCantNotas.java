package com.notas.objetos;

import java.io.Serializable;

/**
 *
 * @author orlan
 */
public class UsuarioCantNotas implements Serializable {

    private int idUsuario;
    private String nombre;
    private String profesion;
    private int notas;

    public UsuarioCantNotas() {
    }

    public UsuarioCantNotas(int idUsuario, String nombre, String profesion, int notas) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.profesion = profesion;
        this.notas = notas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getNotas() {
        return notas;
    }

    public void setNotas(int notas) {
        this.notas = notas;
    }

}
