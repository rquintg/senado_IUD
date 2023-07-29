package com.crud.CongresoIUD_DAO.service.iface;

import com.crud.CongresoIUD_DAO.dto.request.UsuarioDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.UsuarioDTO;
import com.crud.CongresoIUD_DAO.model.Usuario;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioDTO> consultarTodos();
    UsuarioDTO consultarPorId(Long id);
    UsuarioDTO consultarPorUsername(String username);
    String guardar(UsuarioDTORequest usuarioDTORequest);
    Usuario findByUsername(String username);
    UsuarioDTO userInfo(Authentication authentication);
}
