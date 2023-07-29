package com.crud.CongresoIUD_DAO.controller;


import com.crud.CongresoIUD_DAO.dto.request.PartidoPoliticoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.PartidoPoliticoDTO;
import com.crud.CongresoIUD_DAO.service.iface.IPartidoPoliticoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidoPolitico")
public class PartidoPoliticoController {

//    private final com.crud.CongresoIUD_DAO.service.partidoPoliticoService partidoPoliticoService;

    @Autowired
    IPartidoPoliticoService partidoPoliticoService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public ResponseEntity <List<PartidoPoliticoDTO>> getPartido() {
        return ResponseEntity.ok().body(partidoPoliticoService.findAll());
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping
    public ResponseEntity<PartidoPoliticoDTO> registerNewPartido(@RequestBody PartidoPoliticoDTORequest partidoPoliticoDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(partidoPoliticoService.savePartido(partidoPoliticoDTORequest));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PutMapping(value = "{partidoId}")
    public ResponseEntity<PartidoPoliticoDTO> updatePartidoPolitico (@RequestBody PartidoPoliticoDTORequest partidoPoliticoDTORequest, @PathVariable int partidoId) {
        this.partidoPoliticoService.update(partidoPoliticoDTORequest, partidoId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(partidoPoliticoService.savePartido(partidoPoliticoDTORequest));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @DeleteMapping(path = "{partidoId}")
    public ResponseEntity<PartidoPoliticoDTO> deletePartido(@PathVariable("partidoId") Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(partidoPoliticoService.deletePartido(id));
    }

}
