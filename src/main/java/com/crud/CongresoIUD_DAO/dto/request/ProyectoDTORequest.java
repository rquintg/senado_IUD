package com.crud.CongresoIUD_DAO.dto.request;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProyectoDTORequest {

    @NotNull
    @NotEmpty
    long id;
    String nombre;
    String descripcion;



}
