package com.ejemplo.SpringBoot.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private  String esTrabajoactual;
    @NotBlank
    private  String  nombreempresa;
    @NotBlank
    private String fechainicio;
    @NotBlank
    private  String  fechafin;
    @NotBlank
    private String descripcion;
    @NotBlank
    private  String  urlempresa;
    @NotBlank
    private  String  urlimagenempresa;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String esTrabajoactual, String nombreempresa, String fechainicio, String fechafin, String descripcion, String urlempresa, String urlimagenempresa) {
        this.esTrabajoactual = esTrabajoactual;
        this.nombreempresa = nombreempresa;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.descripcion = descripcion;
        this.urlempresa = urlempresa;
        this.urlimagenempresa = urlimagenempresa;
    }

    public String getEsTrabajoactual() {
        return esTrabajoactual;
    }

    public void setEsTrabajoactual(String esTrabajoactual) {
        this.esTrabajoactual = esTrabajoactual;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlempresa() {
        return urlempresa;
    }

    public void setUrlempresa(String urlempresa) {
        this.urlempresa = urlempresa;
    }

    public String getUrlimagenempresa() {
        return urlimagenempresa;
    }

    public void setUrlimagenempresa(String urlimagenempresa) {
        this.urlimagenempresa = urlimagenempresa;
    }
}
