/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.service.impl;

import com.example.yanaforun.entity.Programa;
import com.example.yanaforun.repository.ProgramaRepository;
import com.example.yanaforun.service.ProgramaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crnv_
 */
@Service
public class ProgramaServiceImpl implements ProgramaService {
    @Autowired
    private ProgramaRepository programaRepository;

    @Override
    public List<Programa> findAll() {
        return (List<Programa>) programaRepository.findAll();
    }

    @Override
    public Programa findById(Long id) {
        return programaRepository.findById(id).orElse(null);
    }

    @Override
    public Programa save(Programa programa) {
        return programaRepository.save(programa);
    }

    @Override
    public void delete(Programa programa) {
        programaRepository.delete(programa);
    }

    @Override
    public void deleteById(Long id) {
        programaRepository.deleteById(id);
    }
}
