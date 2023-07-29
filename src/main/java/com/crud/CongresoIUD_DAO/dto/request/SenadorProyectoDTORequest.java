package com.crud.CongresoIUD_DAO.dto.request;

import com.crud.CongresoIUD_DAO.model.Proyecto;
import com.crud.CongresoIUD_DAO.model.Senador;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorProyectoDTORequest {


    Long id;

    @NotBlank(message = "El voto no puede estar vacio")
    @NotNull(message = "El voto no puede ser nulo")
    @Size(min = 2, max = 5, message = "El voto debe tener entre 2 o mas caracteres")
    String voto;

    @NotNull(message = "senador obligatorio")
    Senador senador;

    @NotNull(message = "proyecto obligatorio")
    Proyecto proyecto;

}
