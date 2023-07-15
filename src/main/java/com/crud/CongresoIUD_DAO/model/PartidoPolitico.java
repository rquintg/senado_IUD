package com.crud.CongresoIUD_DAO.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "partido_politico")
public class PartidoPolitico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nombre;

    @Column(name= "descripcion")
    private String descripcion;

    public PartidoPolitico(){}

    public PartidoPolitico(long id) {
        super();
        this.id = id;
    }
}
