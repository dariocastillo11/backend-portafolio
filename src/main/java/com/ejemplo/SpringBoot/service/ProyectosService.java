package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Proyectos;
import com.ejemplo.SpringBoot.repository.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProyectosService  {
    @Autowired
    ProyectosRepository proyectosRepository;

    public List<Proyectos> list(){
        return proyectosRepository.findAll();
    }

    public Optional<Proyectos> getOne(int id){
        return proyectosRepository.findById(id);
    }

    public Optional<Proyectos> getByNombreempresa(String nombreE){
        return proyectosRepository.findBynombre(nombreE);
    }

    public void save(Proyectos pro){
        proyectosRepository.save(pro);
    }

    public void delete(int id){
        proyectosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return proyectosRepository.existsById(id);
    }

    public boolean existsByNombreempresa(String nombreE){
        return proyectosRepository.existsBynombre(nombreE);
    }
}
