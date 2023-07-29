package com.crud.CongresoIUD_DAO.dto.request;

import com.crud.CongresoIUD_DAO.model.Proyecto;
import com.crud.CongresoIUD_DAO.model.Senador;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorProyectoDTORequest {

    @NotNull
    @NotEmpty
    Long id;
    String voto;

    Senador senador;
    Proyecto proyecto;

}
