package com.crud.CongresoIUD_DAO.controller;


import com.crud.CongresoIUD_DAO.dto.request.PartidoPoliticoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.PartidoPoliticoDTO;
import com.crud.CongresoIUD_DAO.service.iface.IPartidoPoliticoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/partidoPolitico")
public class partidoPoliticoController {

//    private final com.crud.CongresoIUD_DAO.service.partidoPoliticoService partidoPoliticoService;

    @Autowired
    IPartidoPoliticoService partidoPoliticoService;

    @GetMapping
    public ResponseEntity <List<PartidoPoliticoDTO>> getPartido() {
        return ResponseEntity.ok().body(partidoPoliticoService.findAll());
    }

    @PostMapping
    public ResponseEntity<PartidoPoliticoDTO> registerNewPartido(@RequestBody PartidoPoliticoDTORequest partidoPoliticoDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(partidoPoliticoService.savePartido(partidoPoliticoDTORequest));
    }
//
//    @PutMapping
//    public ResponseEntity<Object> updatePartido(@RequestBody PartidoPolitico partidoPolitico){
//        return this.partidoPoliticoService.addNewPartido(partidoPolitico);
//    }
//
//    @DeleteMapping(path = "{partidoId}")
//    public ResponseEntity<Object> deletePartido(@PathVariable("partidoId") long id){
//        return this.partidoPoliticoService.deletePartido(id);
//    }

}
