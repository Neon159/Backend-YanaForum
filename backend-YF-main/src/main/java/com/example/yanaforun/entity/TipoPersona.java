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
@Table(name = "tipoPersona")
public class TipoPersona implements Serializable {
    @Id
    @Column(name = "tipp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tippId;
    
    @Column(name = "tipp_nombre")
    private String tippNombre;
    
    @Column(name = "tipp_des")
    private String tippDesc;
}
