
package com.ejemplo.SpringBoot.Controller;

import com.ejemplo.SpringBoot.Dto.dtoEducacion;
import com.ejemplo.SpringBoot.Security.Controller.Mensaje;
import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.service.EducacionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/educacion")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class ControllerEducacion {

    @Autowired
    private EducacionService eduServ;
    @GetMapping("/ver")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = eduServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!eduServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!eduServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        eduServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getTitulo()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(eduServ.existsBytitulo(dtoedu.getTitulo()))
            return new ResponseEntity<>(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);

        Educacion educacion = new Educacion(dtoedu.getTitulo(),dtoedu.getInicio(),
                dtoedu.getFin(), dtoedu.getDescripcion(),dtoedu.getImagenestudio(),dtoedu.getUrlimagen());
        eduServ.save(educacion);

        return new ResponseEntity<>(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        //Validamos si existe el ID
        if(!eduServ.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoedu.getTitulo()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Educacion educacion = eduServ.getOne(id).get();
        educacion.setTitulo(dtoedu.getTitulo());
        educacion.setInicio(dtoedu.getInicio());
        educacion.setFin(dtoedu.getFin());
        educacion.setDescripcion(dtoedu.getDescripcion());
        educacion.setImagenestudio(dtoedu.getImagenestudio());
        educacion.setUrlimagen(dtoedu.getUrlimagen());


        eduServ.save(educacion);
        return new ResponseEntity<>(new Mensaje("Educacion actualizada"), HttpStatus.OK);

    }

}

