package com.example.bartochef;

import java.io.Serializable;

public class Receta implements Serializable {

    private String titulo;
    private String chef;
    private String categoria;
    private String nacionalidad;
    private String ingredientes;
    private String preparacion;
    private int id;
    private int puntos;
    private int plato;

    public Receta(){

    }

    public Receta(int id,String titulo, String chef, String categoria, String nacionalidad, String ingredientes, String preparacion,int puntos, int plato) {
        this.id = id;
        this.titulo = titulo;
        this.chef = chef;
        this.categoria = categoria;
        this.nacionalidad = nacionalidad;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.puntos = puntos;
        this.plato = plato;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public int getPlato() {
        return plato;
    }

    public void setPlato(int plato) {
        this.plato = plato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPuntos() { return puntos; }

    public void setPuntos(int puntos) { this.puntos = puntos;}
}
