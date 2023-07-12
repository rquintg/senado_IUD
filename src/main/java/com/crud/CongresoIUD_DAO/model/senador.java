package com.crud.CongresoIUD_DAO.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity

@Data

public class senador {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String nombre;


    @Column(name = "departamento")
    private String departamento;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "partido_politico")
    private partidoPolitico partidoPolitico;

    public senador(){}


}
