package com.crud.CongresoIUD_DAO.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class partidoPolitico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nombre;

    public partidoPolitico(){}


}
