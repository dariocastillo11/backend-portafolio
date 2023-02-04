package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProyectosRepository extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findBynombre(String nombre);
    public boolean existsBynombre(String nombre);


}
