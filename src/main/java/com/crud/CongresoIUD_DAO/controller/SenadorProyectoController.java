package com.crud.CongresoIUD_DAO.controller;

import com.crud.CongresoIUD_DAO.dto.request.SenadorProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorProyectoDTO;
import com.crud.CongresoIUD_DAO.service.iface.ISenadorProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/senadorproyecto")
public class SenadorProyectoController {

    @Autowired
    ISenadorProyectoService senadorProyectoService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public ResponseEntity<List<SenadorProyectoDTO>> getSenadorProyecto()
    {
        return ResponseEntity.ok().body(senadorProyectoService.findAll());
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping
    public ResponseEntity<SenadorProyectoDTO> registerNewSenadorProyecto(@RequestBody SenadorProyectoDTORequest senadorProyectoDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(senadorProyectoService.saveSenadorProyecto(senadorProyectoDTORequest));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PutMapping(value = "{senadorProyectoId}")
    public ResponseEntity<SenadorProyectoDTO> updateSenadorProyecto (@RequestBody SenadorProyectoDTORequest senadorProyectoDTORequest, @PathVariable int senadorProyectoId){
        this.senadorProyectoService.update(senadorProyectoDTORequest, senadorProyectoId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(senadorProyectoService.saveSenadorProyecto(senadorProyectoDTORequest));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @DeleteMapping(path = "{senadorProyectoId}")
    public ResponseEntity<SenadorProyectoDTO> deleteSenadorProyecto (@PathVariable("senadorProyectoId") Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(senadorProyectoService.deleteSenadorProyecto(id));
    }
}
