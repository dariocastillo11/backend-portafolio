
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducacionService {

    @Autowired
    public EducacionRepository eduRepo;

    public List<Educacion> list(){
        return eduRepo.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return eduRepo.findById(id);
    }

    public Optional<Educacion> getBytitulo(String nombreE){
        return eduRepo.findBytitulo(nombreE);
    }

    public void save(Educacion edu){
        eduRepo.save(edu);
    }

    public void delete(int id){
        eduRepo.deleteById(id);
    }

    public boolean existsById(int id){
        return eduRepo.existsById(id);
    }

    public boolean existsBytitulo(String nombreE){
        return eduRepo.existsBytitulo(nombreE);
    }


}
