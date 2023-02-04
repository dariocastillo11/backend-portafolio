package com.ejemplo.SpringBoot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String inicio;
    private String fin;
    private String descripcion;
    private String imagenestudio;
    private String urlimagen;


    public Educacion() {
    }

    public Educacion( String titulo, String inicio,
                     String fin, String descripcion, String imagenestudio,String urlimagen) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagenestudio = imagenestudio;
        this.urlimagen=urlimagen;
    }

}
