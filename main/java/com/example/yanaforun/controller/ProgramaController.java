/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.controller;

import com.example.yanaforun.entity.Programa;
import com.example.yanaforun.service.ProgramaService;
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
@RequestMapping("api/programa")
@Api(value = "Microservicio de programa", description = "Microservicio de programa")
public class ProgramaController {
    @Autowired
    ProgramaService programaService;
    
    @ApiOperation(value = "Lista de programas"/*,authorizations = { @Authorization(value = "apiKey") }*/)//,  
    @GetMapping
    public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "El programa se ha registrado correctamente.");
        result.put("data", programaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea programa")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Programa programa, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.save(programa);

        result.put("success", true);
        result.put("message", "El programa se ha registrado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
       
    }
    
    @ApiOperation(value = "Actualiza un programa")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Programa programa, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe programa con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            programa.setProgId(id);
            programaService.save(programa); 
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del programa.");
            result.put("data", programa);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        }
    @ApiOperation(value = "Elimina un programa")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe División con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            // data.setEstado(false);
            programaService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            // result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }
    @ApiOperation(value = "Obtiene datos del programa")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.findById(id);
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
