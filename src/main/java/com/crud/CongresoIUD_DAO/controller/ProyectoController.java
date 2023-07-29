package com.crud.CongresoIUD_DAO.controller;


import com.crud.CongresoIUD_DAO.dto.request.ProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.ProyectoDTO;
import com.crud.CongresoIUD_DAO.service.iface.IProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/proyecto")
public class ProyectoController {

    @Autowired
    IProyectoService proyectoService;


    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> getProyecto() {
        return ResponseEntity.ok().body(proyectoService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> saveProyecto(@Valid
            @RequestBody ProyectoDTORequest proyectoDTORequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proyectoService.saveProyecto(proyectoDTORequest));
    }

    @PutMapping(value = "{proyectoId}")
    public ResponseEntity<String> updateProyecto(
            @Valid
            @RequestBody ProyectoDTORequest proyectoDTORequest,
            @PathVariable int proyectoId) {
        this.proyectoService.update(proyectoDTORequest, proyectoId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(proyectoService.update(proyectoDTORequest,proyectoId));
    }


    @DeleteMapping(path = "{proyectoId}")
    public ResponseEntity<String> deleteProyecto(@PathVariable("proyectoId") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(proyectoService.deleteProyecto(id));
    }
}
