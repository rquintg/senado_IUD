package com.crud.CongresoIUD_DAO.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data

public class Senador implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String nombre;


    @Column(name = "departamento")
    private String departamento;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "partido_politico_id")
     partidoPolitico partido_politico_id;

    public Senador(){}

    public Senador(long id) {
        super();
        this.id = id;
    }

    public void prePersist() {
    	if(Objects.isNull(this.fecha)) {
    		this.fecha = LocalDate.now();
    	}
    }




}