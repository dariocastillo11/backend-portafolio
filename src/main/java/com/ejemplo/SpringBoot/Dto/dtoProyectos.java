package com.ejemplo.SpringBoot.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyectos {
    @NotBlank
    private String descripcion;
    @NotBlank
    private String nombre;
    @NotBlank
    private String tecnologias;
    @NotBlank
    private String urlimagen;

    public dtoProyectos() {
    }

    public dtoProyectos(String descripcion, String nombre, String tecnologias, String urlimagen) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tecnologias = tecnologias;
        this.urlimagen = urlimagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
