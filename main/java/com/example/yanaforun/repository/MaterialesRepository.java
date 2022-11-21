/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.yanaforun.repository;

import com.example.yanaforun.entity.Materiales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crnv_
 */
@Repository
public interface MaterialesRepository extends CrudRepository<Materiales, Long> {
    
}
