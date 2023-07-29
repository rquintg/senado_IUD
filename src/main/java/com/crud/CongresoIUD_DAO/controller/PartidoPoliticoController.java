package com.crud.CongresoIUD_DAO.controller;


import com.crud.CongresoIUD_DAO.dto.request.PartidoPoliticoDTORequest;
import com.crud.CongresoIUD_DAO.dto.request.ProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.PartidoPoliticoDTO;
import com.crud.CongresoIUD_DAO.service.iface.IPartidoPoliticoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/partidoPolitico")
public class PartidoPoliticoController {

//    private final com.crud.CongresoIUD_DAO.service.partidoPoliticoService partidoPoliticoService;

    @Autowired
    IPartidoPoliticoService partidoPoliticoService;

    @GetMapping
    public ResponseEntity <List<PartidoPoliticoDTO>> getPartido() {
        return ResponseEntity.ok().body(partidoPoliticoService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> savePartido(@Valid @RequestBody PartidoPoliticoDTORequest partidoPoliticoDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(partidoPoliticoService.savePartido(partidoPoliticoDTORequest));
    }

    @PutMapping(value = "{partidoId}")
    public ResponseEntity<String> updatePartidoPolitico(
            @Valid
            @RequestBody PartidoPoliticoDTORequest partidoPoliticoDTORequest,
            @PathVariable int partidoId) {
        this.partidoPoliticoService.update(partidoPoliticoDTORequest, partidoId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(partidoPoliticoService.update(partidoPoliticoDTORequest,partidoId));
    }


    @DeleteMapping(path = "{partidoId}")
    public ResponseEntity<String> deletePartido(@PathVariable("partidoId") Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(partidoPoliticoService.deletePartido(id));
    }

}
