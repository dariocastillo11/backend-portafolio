
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> list(){
        return personaRepository.findAll();
    }

    public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }

    public Optional<Persona> getBynombre(String nombreE){
        return personaRepository.findBynombre(nombreE);
    }

    public void save(Persona per){
        personaRepository.save(per);
    }

    public void delete(int id){
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }

    public boolean existsBynombre(String nombreE){
        return personaRepository.existsBynombre(nombreE);
    }
}
