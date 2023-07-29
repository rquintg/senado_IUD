package com.crud.CongresoIUD_DAO.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true, nullable = false)
    String nombre;

    @Column(name = "descripcion")
    String descripcion;

    public Proyecto() {
    }

    public Proyecto(long id) {
        super();
        this.id = id;
    }

}
