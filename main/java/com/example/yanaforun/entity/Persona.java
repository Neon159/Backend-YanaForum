/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author crnv_
 */
@Entity
@Data
@Table(name = "persona")
public class Persona implements Serializable {
    @Id
    @Column(name = "pers_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long persId;
    
    @Column(name = "pers_nombres")
    private String persNombres;
    
    @Column(name = "pers_apellido_paterno")
    private String persAP;
    
    @Column(name = "pers_apellido_materno")
    private String persAM;
    
    @Column(name = "pers_dni")
    private int persDni;

    @Column (name = "pers_telefono")
    private int persTelefono;    

}
