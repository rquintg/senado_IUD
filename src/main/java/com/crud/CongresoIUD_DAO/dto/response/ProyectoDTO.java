package com.crud.CongresoIUD_DAO.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProyectoDTO {

    long id;
    String nombre;
    String descripcion;
}
