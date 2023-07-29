package com.crud.CongresoIUD_DAO.controller;

import com.crud.CongresoIUD_DAO.dto.request.UsuarioDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.UsuarioDTO;
import com.crud.CongresoIUD_DAO.service.iface.IUsuarioService;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/signup")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody @Valid UsuarioDTORequest usuarioDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.guardar(usuarioDTORequest));
    }

    @GetMapping
    public ResponseEntity<UsuarioDTO> userInfo(Authentication authentication){
        return ResponseEntity.ok().body(usuarioService.userInfo(authentication));
    }
}
