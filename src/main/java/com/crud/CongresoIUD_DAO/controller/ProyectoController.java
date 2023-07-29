package com.crud.CongresoIUD_DAO.controller;


import com.crud.CongresoIUD_DAO.dto.request.ProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.ProyectoDTO;
import com.crud.CongresoIUD_DAO.service.iface.IProyectoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    IProyectoService proyectoService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> getProyecto() {
        return ResponseEntity.ok().body(proyectoService.findAll());
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping
    public ResponseEntity<ProyectoDTO> saveProyecto(@RequestBody ProyectoDTORequest proyectoDTORequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proyectoService.saveProyecto(proyectoDTORequest));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PutMapping(value = "{proyectoId}")
    public ResponseEntity<ProyectoDTO> updateProyecto(@RequestBody ProyectoDTORequest proyectoDTORequest, @PathVariable int proyectoId) {
        this.proyectoService.update(proyectoDTORequest, proyectoId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proyectoService.saveProyecto(proyectoDTORequest));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @DeleteMapping(path = "{proyectoId}")
    public ResponseEntity<ProyectoDTO> deleteProyecto(@PathVariable("proyectoId") Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proyectoService.deleteProyecto(id));
    }
}
