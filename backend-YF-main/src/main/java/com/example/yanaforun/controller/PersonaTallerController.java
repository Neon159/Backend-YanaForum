/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.controller;


import com.example.yanaforun.entity.PersonaTaller;
import com.example.yanaforun.service.PersonaTallerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping("/personaTaller")
@Api(value = "Microservicio de personaTaller", description = "Microservicio de personaTaller")
public class PersonaTallerController {
    
@Autowired
    PersonaTallerService personatallerService;

    @ApiOperation(value = "Lista de personaTaller")
    @GetMapping
    public List<PersonaTaller> findAll() {
        return (List<PersonaTaller>) personatallerService.findAll();
    }

    @ApiOperation(value = "Datos existentes de personataller")
    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonaTaller> findById(@PathVariable Long id) {
        PersonaTaller personataller = personatallerService.findById(id);
        return ResponseEntity.ok(personataller);
    }
@ApiOperation(value = "Modificar personataller")
    @PutMapping("/update")
    public PersonaTaller update(@RequestBody PersonaTaller personataller){
        return personatallerService.save(personataller);
    }
    @ApiOperation(value = "registrar personataller")
    @PostMapping
    public PersonaTaller save(@RequestBody PersonaTaller personataller) {
        return personatallerService.save(personataller);
    }

    @ApiOperation(value = "Eliminar personataller")
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        personatallerService.deleteById(id);
    }
}
