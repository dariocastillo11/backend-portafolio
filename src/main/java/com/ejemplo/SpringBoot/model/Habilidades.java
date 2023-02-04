package com.ejemplo.SpringBoot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter @Setter
@Entity
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String porcentaje;
    private  String imagen;


    public Habilidades() {
    }

    public Habilidades(String nombre, String porcentaje,String imagen) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imagen=imagen;

    }


}
