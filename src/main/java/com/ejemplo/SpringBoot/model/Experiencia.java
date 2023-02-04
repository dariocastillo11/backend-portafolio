package com.ejemplo.SpringBoot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private  String  nombreempresa;
    private  String esTrabajoactual;
    private String fechainicio;
    private  String  fechafin;
    private String descripcion;
    private  String  urlempresa;
    private  String  urlimagenempresa;


    public Experiencia() {
    }

    public Experiencia(String nombreempresa, String esTrabajoactual,
                       String fechainicio, String fechafin, String descripcion,
                       String urlempresa, String urlimagenempresa) {
        this.nombreempresa = nombreempresa;
        this.esTrabajoactual = esTrabajoactual;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.descripcion = descripcion;
        this.urlempresa = urlempresa;
        this.urlimagenempresa = urlimagenempresa;
    }


}
