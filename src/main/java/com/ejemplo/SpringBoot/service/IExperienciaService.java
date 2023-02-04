package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Experiencia;
import java.util.List;

public interface IExperienciaService {

    public List<Experiencia> verExperiencia();

    public void crearExperiencia(Experiencia per);

    public void borrarExperiencia(Long id);

    public Experiencia buscarExperiencia(Long id);
}
