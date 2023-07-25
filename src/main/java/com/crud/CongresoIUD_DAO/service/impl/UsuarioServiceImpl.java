package com.crud.CongresoIUD_DAO.service.impl;

import com.crud.CongresoIUD_DAO.dto.request.UsuarioDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.UsuarioDTO;
import com.crud.CongresoIUD_DAO.model.Role;
import com.crud.CongresoIUD_DAO.model.Usuario;
import com.crud.CongresoIUD_DAO.repository.IUsuarioRepository;
import com.crud.CongresoIUD_DAO.service.iface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> consultarTodos() {
        return null;
    }

    @Override
    public UsuarioDTO consultarPorId(Long id) {
        return null;
    }

    @Override
    public UsuarioDTO consultarPorUsername(String username) {
        return null;
    }

    @Override
    public UsuarioDTO guardar(UsuarioDTORequest usuarioDTORequest) {
        Usuario usuario;
        Role role = new Role();
        role.setId(2L);
        usuario = usuarioRepository.findByUsername(usuarioDTORequest.getUsername());
        if(usuario != null){
            return null;
        }
        usuario = new Usuario();
        usuario.setNombre(usuarioDTORequest.getNombre());
        usuario.setApellido(usuarioDTORequest.getApellido());
        usuario.setUsername(usuarioDTORequest.getUsername());
        usuario.setPassword(usuarioDTORequest.getPassword());
        usuario.setFechaNacimiento(usuarioDTORequest.getFechaNacimiento());
        usuario.setEnable(true);
        usuario.setRoles(Collections.singletonList(role));
        usuario = usuarioRepository.save(usuario);

        return UsuarioDTO.builder()
                .username(usuario.getUsername())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .enabled(usuario.getEnable())
                .roleId(usuario.getRoles().get(0).getId())
                .build();
    }
}
