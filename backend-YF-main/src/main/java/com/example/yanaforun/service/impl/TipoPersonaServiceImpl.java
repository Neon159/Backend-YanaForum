/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.service.impl;

import com.example.yanaforun.entity.TipoPersona;
import com.example.yanaforun.repository.TipoPersonaRepository;
import com.example.yanaforun.service.TipoPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crnv_
 */
@Service
public class TipoPersonaServiceImpl implements TipoPersonaService {
    @Autowired
    private TipoPersonaRepository tipopersonaRepository;

    @Override
    public List<TipoPersona> findAll() {
        return (List<TipoPersona>) tipopersonaRepository.findAll();
    }

    @Override
    public TipoPersona findById(Long id) {
        return tipopersonaRepository.findById(id).orElse(null);
    }

    @Override
    public TipoPersona save(TipoPersona tipopersona) {
        return tipopersonaRepository.save(tipopersona);
    }

    @Override
    public void delete(TipoPersona tipopersona) {
        tipopersonaRepository.delete(tipopersona);
    }

    @Override
    public void deleteById(Long id) {
        tipopersonaRepository.deleteById(id);
    }
}
