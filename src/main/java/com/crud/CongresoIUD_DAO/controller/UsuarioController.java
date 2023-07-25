package com.crud.CongresoIUD_DAO.controller;

import com.crud.CongresoIUD_DAO.dto.request.UsuarioDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.UsuarioDTO;
import com.crud.CongresoIUD_DAO.service.iface.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTO> create(@RequestBody @Valid UsuarioDTORequest usuarioDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.guardar(usuarioDTORequest));
    }
}
