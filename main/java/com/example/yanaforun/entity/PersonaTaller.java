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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author crnv_
 */
@Entity
@Data
@Table(name = "personaTaller")
public class PersonaTaller implements Serializable {
    @Id
    @Column(name = "pert_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pertId;
    
    @Column (name = "pert_asistencia")
    private int pertAsistencia;
    
    @ManyToOne
    @JoinColumn(name = "pers_id")
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name = "tall_id")
    private Taller taller;
    
}
