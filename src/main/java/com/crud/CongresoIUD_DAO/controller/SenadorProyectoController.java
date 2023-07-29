package com.crud.CongresoIUD_DAO.controller;

import com.crud.CongresoIUD_DAO.dto.request.SenadorProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorProyectoDTO;
import com.crud.CongresoIUD_DAO.service.iface.ISenadorProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/senadorproyecto")
public class SenadorProyectoController {

    @Autowired
    ISenadorProyectoService senadorProyectoService;

    @GetMapping
    public ResponseEntity<List<SenadorProyectoDTO>> getSenadorProyecto()
    {
        return ResponseEntity.ok().body(senadorProyectoService.findAll());
    }

    @PostMapping
    public ResponseEntity<SenadorProyectoDTO> registerNewSenadorProyecto(
            @Valid
            @RequestBody SenadorProyectoDTORequest senadorProyectoDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(senadorProyectoService.saveSenadorProyecto(senadorProyectoDTORequest));
    }

    @PutMapping(value = "{senadorProyectoId}")
    public ResponseEntity<SenadorProyectoDTO> updateSenadorProyecto (
            @Valid
            @RequestBody SenadorProyectoDTORequest senadorProyectoDTORequest, @PathVariable int senadorProyectoId){
        this.senadorProyectoService.update(senadorProyectoDTORequest, senadorProyectoId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(senadorProyectoService.saveSenadorProyecto(senadorProyectoDTORequest));
    }

    @DeleteMapping(path = "{senadorProyectoId}")
    public ResponseEntity<SenadorProyectoDTO> deleteSenadorProyecto (@PathVariable("senadorProyectoId") Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(senadorProyectoService.deleteSenadorProyecto(id));
    }
}
