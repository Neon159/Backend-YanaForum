/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.yanaforun.service;

import com.example.yanaforun.entity.PersonaTaller;
import java.util.List;


/**
 *
 * @author crnv_
 */

public interface PersonaTallerService {
    public List<PersonaTaller> findAll();

    public PersonaTaller findById(Long id);

    public PersonaTaller save(PersonaTaller personataller);

    public void delete(PersonaTaller personataller);

    public void deleteById(Long id);
}

