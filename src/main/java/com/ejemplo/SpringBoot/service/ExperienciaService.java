package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService{

    @Autowired
    ExperienciaRepository experienciaRepository;

    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByNombreempresa(String nombreE){
        return experienciaRepository.findByNombreempresa(nombreE);
    }

    public void save(Experiencia expe){
        experienciaRepository.save(expe);
    }

    public void delete(int id){
        experienciaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    }

    public boolean existsByNombreempresa(String nombreE){
        return experienciaRepository.existsByNombreempresa(nombreE);
    }
}
