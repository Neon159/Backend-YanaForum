/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.controller;

import com.example.yanaforun.entity.TipoPersona;
import com.example.yanaforun.service.TipoPersonaService;
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
@RequestMapping("/tipoPersona")
@Api(value = "Microservicio de tipoPersona", description = "Microservicio de tipoPersona")
public class TipoPersonaController {
    @Autowired
    TipoPersonaService tipopersonaService;

    @ApiOperation(value = "Lista de tipoPersona")
    @GetMapping
    public List<TipoPersona> findAll() {
        return (List<TipoPersona>) tipopersonaService.findAll();
    }

    @ApiOperation(value = "Datos existentes tipoPersona")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoPersona> findById(@PathVariable Long id) {
        TipoPersona tipopersona = tipopersonaService.findById(id);
        return ResponseEntity.ok(tipopersona);
    }
    @ApiOperation(value = "Modificar tipoPersona")
    @PutMapping("/update")
    public TipoPersona update(@RequestBody TipoPersona tipopersona){
        return tipopersonaService.save(tipopersona);
    }
    @ApiOperation(value = "registrar tipoPersona")
    @PostMapping
    public TipoPersona save(@RequestBody TipoPersona tipopersona) {
        return tipopersonaService.save(tipopersona);
    }

    @ApiOperation(value = "Eliminar tipoPersona")
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        tipopersonaService.deleteById(id);
    }
}
