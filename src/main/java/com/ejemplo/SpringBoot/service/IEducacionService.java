package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Educacion;
import java.util.List;

public interface IEducacionService {

    public List<Educacion> verEducacion();

    public void crearEducacion(Educacion per);

    public void borrarEducacion(Long id);

    public Educacion buscarEducacion(Long id);
}
