/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.service.impl;

import com.example.yanaforun.entity.PersonaTaller;
import com.example.yanaforun.repository.PersonaTallerRepository;
import com.example.yanaforun.service.PersonaTallerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crnv_
 */
@Service
public class PersonaTallerServiceImpl implements PersonaTallerService {
    @Autowired
    private PersonaTallerRepository personatallerRepository;

    @Override
    public List<PersonaTaller> findAll() {
        return (List<PersonaTaller>) personatallerRepository.findAll();
    }

    @Override
    public PersonaTaller findById(Long id) {
        return personatallerRepository.findById(id).orElse(null);
    }

    @Override
    public PersonaTaller save(PersonaTaller personataller) {
        return personatallerRepository.save(personataller);
    }

    @Override
    public void delete(PersonaTaller personataller) {
        personatallerRepository.delete(personataller);
    }

    @Override
    public void deleteById(Long id) {
        personatallerRepository.deleteById(id);
    }
}
