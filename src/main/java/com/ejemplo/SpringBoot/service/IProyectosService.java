package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Proyectos;
import java.util.List;




public interface IProyectosService {
    public List<Proyectos> verProyectos();
    public void crearProyectos(Proyectos pro);
    public void borrarProyectos(Long id);
    public Proyectos buscarProyectos(Long id);
}

