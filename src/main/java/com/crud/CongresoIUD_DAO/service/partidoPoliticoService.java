package com.crud.CongresoIUD_DAO.service;

import com.crud.CongresoIUD_DAO.model.partidoPolitico;
import com.crud.CongresoIUD_DAO.repository.partidoPoliticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class partidoPoliticoService {

    HashMap <String, Object> datos;

    private final com.crud.CongresoIUD_DAO.repository.partidoPoliticoRepository partidoPoliticoRepository;

    @Autowired
    public partidoPoliticoService(partidoPoliticoRepository partidoPoliticoRepository) {
        this.partidoPoliticoRepository = partidoPoliticoRepository;
    }

    public List<partidoPolitico> getPartido() {
        return this.partidoPoliticoRepository.findAll();
    }

    public ResponseEntity<Object> addNewPartido(partidoPolitico partidoPolitico){
        Optional <partidoPolitico> res = partidoPoliticoRepository.findPartidoPoliticoByNombre(partidoPolitico.getNombre());
        datos = new HashMap<>();

        if(res.isPresent() && partidoPolitico.getId() == 0 ){
            datos.put("error", true);
            datos.put("mensaje", "El partido ya existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        datos.put("mensaje", "El partido politico ha sido creado");

        if(partidoPolitico.getId() != 0){
            datos.put("mensaje", "El partido politico ha sido Modificado");
        }

        partidoPoliticoRepository.save(partidoPolitico);
        datos.put("data", partidoPolitico);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deletePartido(Long partidoPoliticoId){
        datos = new HashMap<>();
        boolean exists = partidoPoliticoRepository.existsById(partidoPoliticoId);

        if(!exists){
            datos.put("error", true);
            datos.put("mensaje", "El partido politico no existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.NOT_FOUND
            );
        }

        this.partidoPoliticoRepository.deleteById(partidoPoliticoId);
        datos.put("mensaje", "El partido politico ha sido eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.OK
        );
    }

}
