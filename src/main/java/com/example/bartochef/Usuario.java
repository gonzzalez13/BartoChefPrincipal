package com.example.bartochef;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String apellidos;
    private String edad;
    private String username;
    private String password;
    private String correo;


    public Usuario(String nombre, String apellidos, String edad, String username, String password, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.username = username;
        this.password = password;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }

    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEdad() { return edad; }

    public void setEdad(String edad) { this.edad = edad; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }
}
