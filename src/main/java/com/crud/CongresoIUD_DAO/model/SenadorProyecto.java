package com.crud.CongresoIUD_DAO.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "senador_proyectos", uniqueConstraints = {@UniqueConstraint( columnNames = {"senador_id", "proyecto_id"})})
public class SenadorProyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    String voto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senador_id")
    Senador senador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id")
    Proyecto proyecto;


    public SenadorProyecto() {
    }

    public SenadorProyecto(long id) {
        this.id = id;
    }
}
