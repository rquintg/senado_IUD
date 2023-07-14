package com.crud.CongresoIUD_DAO.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorDTO {

    Long id;
    String nombre;
    String departamento;
    String fecha;
    String partido_politico_id;
}
