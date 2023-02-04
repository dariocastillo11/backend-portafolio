package com.ejemplo.SpringBoot.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidades {

    @NotBlank
    private String nombre;
    @NotBlank
    private String porcentaje;
    @NotBlank
    private String imagen;
    public dtoHabilidades() {
    }

    public dtoHabilidades(String nombre, String porcentaje,String imagen) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imagen=imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
