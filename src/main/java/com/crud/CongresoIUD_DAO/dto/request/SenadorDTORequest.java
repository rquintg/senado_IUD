package com.crud.CongresoIUD_DAO.dto.request;


import com.crud.CongresoIUD_DAO.model.PartidoPolitico;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorDTORequest {

    Long id;

    @NotBlank(message = "El nombre del senador no puede estar vacio")
    @NotNull(message = "El nombre del senador no puede ser nulo")
    @Size(min = 2, max = 120, message = "El nombre del senador debe tener entre 2 y 120 caracteres")
    String nombre;

    @NotBlank(message = "El departamento del senador no puede estar vacio")
    @NotNull(message = "El departamento del senador no puede ser nulo")
    @Size(min = 2, max = 120, message = "El departamento del senador debe tener entre 2 y 120 caracteres")
    String departamento;

    @JsonProperty("fecha")
    LocalDate fecha;

    @NotNull(message = "Partido politico obligatorio")
    PartidoPolitico partido_politico_id;
}
