package com.crud.CongresoIUD_DAO.dto.request;

import com.crud.CongresoIUD_DAO.model.Proyecto;
import com.crud.CongresoIUD_DAO.model.Senador;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorProyectoDTORequest {

    @NotNull @NotEmpty
    Long id;
    String voto;

    Senador senador_id;
    Proyecto proyecto_id;

}
