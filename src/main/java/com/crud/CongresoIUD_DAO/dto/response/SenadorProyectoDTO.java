package com.crud.CongresoIUD_DAO.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorProyectoDTO {

    Long id;
    String voto;
    String senador_id;
    String proyecto_id;

}
