
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Habilidades;
import com.ejemplo.SpringBoot.repository.HabilidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabilidadesService {

    @Autowired
    public HabilidadesRepository haRepo;

    public List<Habilidades> list(){
        return haRepo.findAll();
    }

    public Optional<Habilidades> getOne(int id){
        return haRepo.findById(id);
    }

    public Optional<Habilidades> getBynombre(String nombreE){
        return haRepo.findBynombre(nombreE);
    }

    public void save(Habilidades hab){
        haRepo.save(hab);
    }

    public void delete(int id){
        haRepo.deleteById(id);
    }

    public boolean existsById(int id){
        return haRepo.existsById(id);
    }

    public boolean existsBynombre(String nombreE){
        return haRepo.existsBynombre(nombreE);
    }


}
