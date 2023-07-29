package com.crud.CongresoIUD_DAO.dto.request;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProyectoDTORequest {

    Long id;

    @NotBlank(message = "El nombre del proyecto no puede estar vacio")
    @NotNull(message = "El nombre del proyecto no puede ser nulo")
    @Size(min = 2, max = 120, message = "El nombre del proyecto debe tener entre 2 y 120 caracteres")
    String nombre;

    @NotBlank(message = "La descripcion del proyecto no puede estar vacio")
    @NotNull(message = "La descripcion del proyecto no puede ser nulo")
    @NotEmpty(message = "La descripcion del proyecto no puede estar vacio")
    String descripcion;



}
