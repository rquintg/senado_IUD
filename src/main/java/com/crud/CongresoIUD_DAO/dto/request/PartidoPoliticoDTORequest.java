package com.crud.CongresoIUD_DAO.dto.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartidoPoliticoDTORequest {

    @NotNull @NotEmpty
    Long id;

    String nombre;
    String descripcion;
}
