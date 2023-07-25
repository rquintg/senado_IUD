package com.crud.CongresoIUD_DAO.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsuarioDTO {

    String username;

    String nombre;

    String apellido;

    LocalDate fechaNacimiento;

    Boolean enabled;

    Long roleId;
}
