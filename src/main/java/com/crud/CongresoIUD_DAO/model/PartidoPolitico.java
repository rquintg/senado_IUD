package com.crud.CongresoIUD_DAO.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "partido_politico")
public class partidoPolitico  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nombre;

    public partidoPolitico(){}

    public partidoPolitico(long id) {
        super();
        this.id = id;
    }
}
