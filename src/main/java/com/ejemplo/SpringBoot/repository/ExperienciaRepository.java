package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombreempresa(String nombreempresa);
    public boolean existsByNombreempresa(String nombreempresa);


}
