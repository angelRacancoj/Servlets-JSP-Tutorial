package com.notas.objetos;

import java.io.Serializable;

/**
 *
 * @author orlan
 */
public class Usuario implements Serializable{
    
    public static final String USUARIO_DB_NAME = "USUARIO";
    public static final String USUARIO_ID_DB_NAME = "idUsuario";
    public static final String NOMBRE_DB_NAME = "nombre";
    public static final String PROFESION_DB_NAME = "profesion";
    public static final String PASSWORD_DB_NAME = "password";

    private int idUsuario;
    private String nombre;
    private String profesion;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String profesion, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.profesion = profesion;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
