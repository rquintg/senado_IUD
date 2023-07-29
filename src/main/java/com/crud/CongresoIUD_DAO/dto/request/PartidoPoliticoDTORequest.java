package com.crud.CongresoIUD_DAO.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartidoPoliticoDTORequest {

    long id;

    @NotBlank(message = "Se requiere el nombre del partido polito")
    @NotNull(message = "El nombre del partido politico no puede ser nulo")
    @Size(min = 2, max = 120, message = "El nombre del partido politico debe tener entre 2 y 120 caracteres")
    String nombre;

    @NotBlank(message = "La descripción del proyecto no puede estar vacia")
    @NotNull(message = "la descripción del proyecto no puede ser nulo")
    String descripcion;
}

