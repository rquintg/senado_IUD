package com.crud.CongresoIUD_DAO.controller;

import com.crud.CongresoIUD_DAO.model.senador;
import com.crud.CongresoIUD_DAO.service.senadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/senador")
public class senadorController {

    private final com.crud.CongresoIUD_DAO.service.senadorService senadorService;

    @Autowired
    public senadorController(senadorService senadorService) {
        this.senadorService = senadorService;
    }

    @GetMapping
    public List<senador> getSenador() {
        return senadorService.getSenador();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewSenador(@RequestBody senador senador){
        return this.senadorService.addNewSenador(senador);
    }

    @PutMapping
    public ResponseEntity<Object> updateSenador(@RequestBody senador senador){
        return this.senadorService.addNewSenador(senador);
    }

    @DeleteMapping(path = "{senadorId}")
    public ResponseEntity<Object> deleteSenador(@PathVariable("senadorId") long id){
        return this.senadorService.deleteSenador(id);
    }

}
