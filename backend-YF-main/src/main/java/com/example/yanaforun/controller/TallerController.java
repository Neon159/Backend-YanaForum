/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.controller;

import com.example.yanaforun.entity.Taller;
import com.example.yanaforun.service.TallerService;
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
@RequestMapping("/taller")
@Api(value = "Microservicio de taller", description = "Microservicio de taller")
public class TallerController {
    @Autowired
    TallerService tallerService;

    @ApiOperation(value = "Datos existentes de taller")
    @GetMapping
    public List<Taller> findAll() {
        return (List<Taller>) tallerService.findAll();
    }
    @ApiOperation(value = "Modificar taller")
    @PutMapping("/update")
    public Taller update(@RequestBody Taller taller){
        return tallerService.save(taller);
    }
    @ApiOperation(value = "Listar taller")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Taller> findById(@PathVariable Long id) {
        Taller taller = tallerService.findById(id);
        return ResponseEntity.ok(taller);
    }

    @ApiOperation(value = "registrar taller")
    @PostMapping
    public Taller save(@RequestBody Taller taller) {
        return tallerService.save(taller);
    }

    @ApiOperation(value = "Eliminar taller")
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        tallerService.deleteById(id);
    }
}
