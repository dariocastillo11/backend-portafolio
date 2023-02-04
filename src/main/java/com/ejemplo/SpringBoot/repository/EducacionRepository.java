package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findBytitulo(String titulo);
    public boolean existsBytitulo(String titulo);


}
