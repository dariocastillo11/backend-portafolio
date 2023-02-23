package com.ejemplo.SpringBoot.Controller;

import com.ejemplo.SpringBoot.Dto.dtoPersona;
import com.ejemplo.SpringBoot.Security.Controller.Mensaje;
import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/persona")
@CrossOrigin(origins = "https://portafolio-dariocastillo11.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class  Controller {
    @Autowired
    private PersonaService persoServ;
    @GetMapping("/ver")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = persoServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!persoServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = persoServ.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!persoServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        persoServ.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
   /* @PostMapping("/new")
    public void agregarExperiencia(@RequestBody Experiencia exp ){
        expServ.crearExperiencia(exp);
    }*/

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoper){
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(persoServ.existsBynombre(dtoper.getNombre()))
            return new ResponseEntity<>(new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);

        Persona persona = new Persona(dtoper.getNombre(),dtoper.getApellido(),
                dtoper.getDomicilio(), dtoper.getFechanacimiento(),dtoper.getSobremi(),dtoper.getUrlfoto());
        persoServ.save(persona);

        return new ResponseEntity<>(new Mensaje("persona agregada"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoper){
        //Validamos si existe el ID
        if(!persoServ.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        //if(expServ.existsByNombre(dtoexp.getNombreempresa()) && expServ.getByNombre(dtoexp.getNombreempresa()).get().getId() != id)
        //   return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Persona persona = persoServ.getOne(id).get();
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setDomicilio(dtoper.getDomicilio());
        persona.setFechanacimiento(dtoper.getFechanacimiento());
        persona.setSobremi(dtoper.getSobremi());
        persona.setUrlfoto(dtoper.getUrlfoto());

        persoServ.save(persona);
        return new ResponseEntity<>(new Mensaje("Persona actualizada"), HttpStatus.OK);

    }

}
