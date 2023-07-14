package com.crud.CongresoIUD_DAO.controller;

import com.crud.CongresoIUD_DAO.dto.response.SenadorDTO;
import com.crud.CongresoIUD_DAO.service.iface.ISenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/senador")
public class SenadorController {

    //private final com.crud.CongresoIUD_DAO.service.senadorService senadorService;

    @Autowired
    ISenadorService senadorService;


    @GetMapping
    public ResponseEntity<List<SenadorDTO>> getSenadores() {
        return ResponseEntity.ok().body(senadorService.findAll());
    }

    /*@PostMapping
    public ResponseEntity<Object> registerNewSenador(@RequestBody Senador senador){
        return this.senadorService.addNewSenador(senador);
    }

    @PutMapping
    public ResponseEntity<Object> updateSenador(@RequestBody Senador senador){
        return this.senadorService.addNewSenador(senador);
    }

    @DeleteMapping(path = "{senadorId}")
    public ResponseEntity<Object> deleteSenador(@PathVariable("senadorId") long id){
        return this.senadorService.deleteSenador(id);
    }*/

}
