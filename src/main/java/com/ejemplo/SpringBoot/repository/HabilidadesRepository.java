package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer>{

    public Optional<Habilidades> findBynombre(String nombre);
    public boolean existsBynombre(String nombre);

}
