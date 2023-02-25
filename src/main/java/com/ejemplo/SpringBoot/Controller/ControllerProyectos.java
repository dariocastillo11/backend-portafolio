package com.ejemplo.SpringBoot.Controller;
import com.ejemplo.SpringBoot.Dto.dtoProyectos;
import com.ejemplo.SpringBoot.Security.Controller.Mensaje;
import com.ejemplo.SpringBoot.model.Proyectos;
import com.ejemplo.SpringBoot.service.ProyectosService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/proyectos")
//@CrossOrigin(origins = "https://portafolio-dariocastillo11.web.app")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerProyectos {

    @Autowired
    private ProyectosService proyecServ;

    @GetMapping("/ver")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyecServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyecServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyecServ.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyecServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyecServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
   /* @PostMapping("/new")
    public void agregarExperiencia(@RequestBody Experiencia exp ){
        expServ.crearExperiencia(exp);
    }*/

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtopro){
        if(StringUtils.isBlank(dtopro.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyecServ.existsByNombreempresa(dtopro.getNombre()))
            return new ResponseEntity<>(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = new Proyectos(dtopro.getDescripcion(),dtopro.getNombre(),
                dtopro.getTecnologias(), dtopro.getUrlimagen());
        proyecServ.save(proyectos);

        return new ResponseEntity<>(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtopro){
        //Validamos si existe el ID
        if(!proyecServ.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        //if(expServ.existsByNombre(dtoexp.getNombreempresa()) && expServ.getByNombre(dtoexp.getNombreempresa()).get().getId() != id)
        //   return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopro.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Proyectos proyectos = proyecServ.getOne(id).get();
        proyectos.setNombre(dtopro.getNombre());
        proyectos.setDescripcion(dtopro.getDescripcion());
        proyectos.setTecnologias(dtopro.getTecnologias());
        proyectos.setUrlimagen(dtopro.getUrlimagen());


        proyecServ.save(proyectos);
        return new ResponseEntity<>(new Mensaje("Proyectos actualizados"), HttpStatus.OK);

    }

}

