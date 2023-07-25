package com.crud.CongresoIUD_DAO.dto.request;


import com.crud.CongresoIUD_DAO.model.PartidoPolitico;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorDTORequest {
    @NotNull @NotEmpty
    Long id;

    String nombre;
    String departamento;
    LocalDate fecha;

    PartidoPolitico partido_politico_id;
}
