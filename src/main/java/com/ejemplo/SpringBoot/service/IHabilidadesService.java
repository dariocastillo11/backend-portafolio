package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Habilidades;
import java.util.List;

public interface IHabilidadesService {

    public List<Habilidades> verHabilidades();

    public void crearHabilidades(Habilidades per);

    public void borrarHabilidades(Long id);

    public Habilidades buscarHabilidades(Long id);
}
