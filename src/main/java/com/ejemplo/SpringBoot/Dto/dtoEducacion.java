package com.ejemplo.SpringBoot.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank
    private String inicio;
    @NotBlank
    private String fin;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imagenestudio;
    @NotBlank
    private String urlimagen;

    public dtoEducacion() {
    }

    public dtoEducacion(String titulo, String inicio, String fin, String descripcion, String imagenestudio, String urlimagen) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagenestudio = imagenestudio;
        this.urlimagen = urlimagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenestudio() {
        return imagenestudio;
    }

    public void setImagenestudio(String imagenestudio) {
        this.imagenestudio = imagenestudio;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
