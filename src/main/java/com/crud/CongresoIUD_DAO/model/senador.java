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

    @Column(unique = true)
    private String nombre;

    private String partido;
    private String departamento;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "partido_politico")
    private partidoPolitico partidoPolitico;

    public senador(){}

   /* public senador(long id, String nombre, String partido, String departamento, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
        this.departamento = departamento;
        this.fecha = fecha;
    }

    public senador(String nombre, String partido, String departamento, LocalDate fecha) {
        this.nombre = nombre;
        this.partido = partido;
        this.departamento = departamento;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }*/
}
