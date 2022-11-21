/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.controller;

import com.example.yanaforun.entity.Persona;
import com.example.yanaforun.service.PersonaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crnv_
 */
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/persona")
@Api(value = "Microservicio de persona", description = "Microservicio de persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

   @ApiOperation(value = "Lista de personas"/*,authorizations = { @Authorization(value = "apiKey") }*/)//,  
    @GetMapping
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "El programa se ha registrado correctamente.");
        result.put("data", personaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea persona")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Persona persona, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = personaService.save(persona);

        result.put("success", true);
        result.put("message", "La persona se ha registrado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Actualiza una persona")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Persona persona, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = personaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe empleado con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            persona.setPersId(id);
            personaService.save(persona);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del empleado.");
            result.put("data", persona);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        }
    @ApiOperation(value = "Elimina una persona")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = personaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe División con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            // data.setEstado(false);
            personaService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            // result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }
    @ApiOperation(value = "Obtiene datos de una persona")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = personaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe empleado con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
