package com.crud.CongresoIUD_DAO.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
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
    @NotEmpty(message = "El correo electronico no puede estar vacio")
    @Email(message =  "No cumple con formato de tipo email")
    String username;

    @NotNull(message = "El nombre es obligatorio")
    @NotEmpty(message = "El nombre no puede estar en blanco o vacio")
    @Size(min =  2, max = 120)
    String nombre;

    String apellido;

    @NotEmpty(message = "Se requiere definir una contraseña")
    @Size(min = 5, message = "Debe suministrar una contraseña segura")
    String password;

    @JsonProperty("fecha_nacimiento")
    LocalDate fechaNacimiento;

    Boolean enable;

}
