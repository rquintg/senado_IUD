package com.crud.CongresoIUD_DAO.controller;

import com.crud.CongresoIUD_DAO.dto.request.SenadorDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorDTO;
import com.crud.CongresoIUD_DAO.service.iface.ISenadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<String> registerNewSenador(
            @Valid @RequestBody SenadorDTORequest senadorDTORequest)
    {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(senadorService.saveSenador(senadorDTORequest));
    }

    @PutMapping(value = "{senadorId}")
    public ResponseEntity<String> updateSenador (
            @Valid
            @RequestBody SenadorDTORequest senadorDTORequest, @PathVariable int senadorId)
  {
        this.senadorService.update(senadorDTORequest, senadorId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(senadorService.update(senadorDTORequest, senadorId));
    }



    @DeleteMapping(path = "{senadorId}")
    public ResponseEntity<String
            > deleteSenador(@PathVariable("senadorId") long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(senadorService.deleteSenador(id));
    }

}
