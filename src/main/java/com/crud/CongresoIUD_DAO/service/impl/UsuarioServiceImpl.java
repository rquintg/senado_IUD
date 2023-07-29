package com.crud.CongresoIUD_DAO.service.impl;

import com.crud.CongresoIUD_DAO.dto.request.UsuarioDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.UsuarioDTO;
import com.crud.CongresoIUD_DAO.model.Role;
import com.crud.CongresoIUD_DAO.model.Usuario;
import com.crud.CongresoIUD_DAO.repository.IUsuarioRepository;
import com.crud.CongresoIUD_DAO.service.iface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

    @Lazy
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
    public String guardar(UsuarioDTORequest usuarioDTORequest) {
        Usuario usuario;
        Role role = new Role();
        role.setId(2L);
        usuario = usuarioRepository.findByUsername(usuarioDTORequest.getUsername());
        if(usuario != null){
            throw new IllegalArgumentException(
                    "El correo electronico " + usuarioDTORequest.getUsername() + " ya se encuentra registrado");
        }
        usuario = new Usuario();
        log.info("password cifrada{}", passwordEncoder.encode(usuarioDTORequest.getPassword()));
        usuario.setNombre(usuarioDTORequest.getNombre());
        usuario.setApellido(usuarioDTORequest.getApellido());
        usuario.setUsername(usuarioDTORequest.getUsername());
        usuario.setPassword(passwordEncoder.encode(usuarioDTORequest.getPassword()));
        usuario.setFechaNacimiento(usuarioDTORequest.getFechaNacimiento());
        usuario.setEnable(true);
        usuario.setRoles(Collections.singletonList(role));
        usuario = usuarioRepository.save(usuario);

        return "Se registro el usuario " + usuario.getNombre() + " de manera satisfactoria";
    }

    @Override
    public Usuario findByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        return usuario;
    }

    @Override
    public UsuarioDTO userInfo(Authentication authentication) {
        if(!authentication.isAuthenticated()){
            throw new IllegalArgumentException("No se encuentra autenticado");
        }
        String userName = authentication.getName();
        Usuario usuario = usuarioRepository.findByUsername(userName);
        if(usuario == null){
            throw new IllegalCallerException("El usuario no existe");
        }
        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .roles(usuario.getRoles().stream().map(role -> role.getNombre()).collect(Collectors.toList()))
                .username(usuario.getUsername())
                .build();
        return usuarioDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuario =usuarioRepository.findByUsername(username);
        if(usuario == null) {
            log.error("Error al momento de realizar el login, el usuario " + username + " no existe");
            throw new UsernameNotFoundException("Error de login, no existe el usuario: "+ username);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role: usuario.getRoles()){
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getNombre());
            log.info("Rol {}", authority.getAuthority());
            authorities.add(authority);
        }
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnable(),true, true,true, authorities);
    }

}
