
package com.ejemplo.SpringBoot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;
    private String domicilio;
    private  String fechanacimiento;
    private String sobremi;
    private String urlfoto;

   
    public Persona() {
    }

    public Persona(String nombre, String apellido, String domicilio,
                   String fechanacimiento, String sobremi, String urlfoto) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.domicilio=domicilio;
        this.fechanacimiento=fechanacimiento;
        this.sobremi=sobremi;
        this.urlfoto=urlfoto;
    }
    
    
}
