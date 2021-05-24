package com.example.bartochef;

import java.io.Serializable;

public class EntidadList implements Serializable {

    private int imgfoto;
    private String titulo;


    public EntidadList(int imgfoto, String titulo) {
        this.imgfoto = imgfoto;
        this.titulo = titulo;
    }

    public int getImgfoto() {
        return imgfoto;
    }

    public void setImgfoto(int imgfoto) {
        this.imgfoto = imgfoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
