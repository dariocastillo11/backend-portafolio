
package com.ejemplo.SpringBoot.Controller;

import com.ejemplo.SpringBoot.Dto.dtoHabilidades;
import com.ejemplo.SpringBoot.Security.Controller.Mensaje;
import com.ejemplo.SpringBoot.model.Habilidades;
import com.ejemplo.SpringBoot.service.HabilidadesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/habilidades")
@CrossOrigin(origins = "https://portafolio-dariocastillo11.web.app")
public class ControllerHabilidades {

    @Autowired
    private HabilidadesService haServ;

    @GetMapping("/ver")
    public ResponseEntity<List<Habilidades>> list(){
        List<Habilidades> list = haServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!haServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidades habilidades = haServ.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!haServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        haServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtohab){
        if(StringUtils.isBlank(dtohab.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(haServ.existsBynombre(dtohab.getNombre()))
            return new ResponseEntity<>(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);

        Habilidades habilidades = new Habilidades(dtohab.getNombre(),dtohab.getPorcentaje(),dtohab.getImagen());
        haServ.save(habilidades);

        return new ResponseEntity<>(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidades dtohab){
        //Validamos si existe el ID
        if(!haServ.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtohab.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Habilidades habilidades = haServ.getOne(id).get();
        habilidades.setNombre(dtohab.getNombre());
        habilidades.setPorcentaje(dtohab.getPorcentaje());
        habilidades.setImagen(dtohab.getImagen());

        haServ.save(habilidades);
        return new ResponseEntity<>(new Mensaje("habilidad actualizada"), HttpStatus.OK);

    }

}

