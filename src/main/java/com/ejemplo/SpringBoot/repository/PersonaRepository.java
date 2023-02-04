
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    public Optional<Persona> findBynombre(String nombre);
    public boolean existsBynombre(String nombre);



}
