package com.ejemplo.SpringBoot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter @Setter
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descripcion;
    private String nombre;
    private String tecnologias;
    private String urlimagen;


    public Proyectos() {
    }

    public Proyectos(String descripcion, String nombre, String tecnologias,String urlimagen) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tecnologias = tecnologias;
        this.urlimagen= urlimagen;
    }


}
