package com.crud.CongresoIUD_DAO.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsuarioDTORequest {

    @NotNull(message = "El username es obligatorio")
    @Email(message =  "No cumple con formato de tipo email")
    String username;

    @NotNull(message = "El nombre es obligatorio")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min =  2, max = 120)
    String nombre;

    String apellido;

    @Size(min = 5, message = "Debe suministrar una contraseña segura")
    String password;

    @JsonProperty("fecha_nacimiento")
    LocalDate fechaNacimiento;

    Boolean enable;

}
