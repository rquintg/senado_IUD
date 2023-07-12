package com.crud.CongresoIUD_DAO.controller;


import com.crud.CongresoIUD_DAO.model.partidoPolitico;
import com.crud.CongresoIUD_DAO.service.partidoPoliticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/partidoPolitico")
public class partidoPoliticoController {

    private final com.crud.CongresoIUD_DAO.service.partidoPoliticoService partidoPoliticoService;

    @Autowired
    public partidoPoliticoController(partidoPoliticoService partidoPoliticoService) {
        this.partidoPoliticoService = partidoPoliticoService;
    }

    @GetMapping
    public List<partidoPolitico> getPartido() {
        return partidoPoliticoService.getPartido();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewPartido(@RequestBody partidoPolitico partidoPolitico){
        return this.partidoPoliticoService.addNewPartido(partidoPolitico);
    }

    @PutMapping
    public ResponseEntity<Object> updatePartido(@RequestBody partidoPolitico partidoPolitico){
        return this.partidoPoliticoService.addNewPartido(partidoPolitico);
    }

    @DeleteMapping(path = "{partidoId}")
    public ResponseEntity<Object> deletePartido(@PathVariable("partidoId") long id){
        return this.partidoPoliticoService.deletePartido(id);
    }

}
