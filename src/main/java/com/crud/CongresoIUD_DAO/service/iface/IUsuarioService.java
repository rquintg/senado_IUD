package com.crud.CongresoIUD_DAO.service.iface;

import com.crud.CongresoIUD_DAO.dto.request.UsuarioDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioDTO> consultarTodos();
    UsuarioDTO consultarPorId(Long id);
    UsuarioDTO consultarPorUsername(String username);
    UsuarioDTO guardar(UsuarioDTORequest usuarioDTORequest);
}
