package com.ejemplo.SpringBoot.Controller;

import com.ejemplo.SpringBoot.Dto.dtoExperiencia;
import com.ejemplo.SpringBoot.Security.Controller.Mensaje;
import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.service.ExperienciaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/experiencia")
@CrossOrigin(origins = {"http://localhost:4200","https://portafolio-dariocastillo11.web.app"})
public class ControllerExperiencia {

    @Autowired
    private ExperienciaService expServ;
    @GetMapping("/ver")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        expServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
   /* @PostMapping("/new")
    public void agregarExperiencia(@RequestBody Experiencia exp ){
        expServ.crearExperiencia(exp);
    }*/

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreempresa()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expServ.existsByNombreempresa(dtoexp.getNombreempresa()))
            return new ResponseEntity<>(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = new Experiencia(dtoexp.getNombreempresa(),dtoexp.getEsTrabajoactual(),
                dtoexp.getFechainicio(), dtoexp.getFechafin(),dtoexp.getDescripcion(),dtoexp.getUrlempresa(),
                dtoexp.getUrlimagenempresa());
        expServ.save(experiencia);

        return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        //Validamos si existe el ID
        if(!expServ.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        //if(expServ.existsByNombre(dtoexp.getNombreempresa()) && expServ.getByNombre(dtoexp.getNombreempresa()).get().getId() != id)
         //   return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getNombreempresa()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = expServ.getOne(id).get();
        experiencia.setNombreempresa(dtoexp.getNombreempresa());
        experiencia.setEsTrabajoactual(dtoexp.getEsTrabajoactual());
        experiencia.setFechainicio(dtoexp.getFechainicio());
        experiencia.setFechafin(dtoexp.getFechafin());
        experiencia.setDescripcion(dtoexp.getDescripcion());
        experiencia.setUrlempresa(dtoexp.getUrlempresa());
        experiencia.setUrlimagenempresa(dtoexp.getUrlimagenempresa());


        expServ.save(experiencia);
        return new ResponseEntity<>(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }

}

