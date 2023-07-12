package com.crud.CongresoIUD_DAO.service;

import com.crud.CongresoIUD_DAO.model.senador;
import com.crud.CongresoIUD_DAO.repository.senadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class senadorService {

    HashMap <String, Object> datos;

    private final com.crud.CongresoIUD_DAO.repository.senadorRepository senadorRepository;

    @Autowired
    public senadorService(senadorRepository senadorRepository) {
        this.senadorRepository = senadorRepository;
    }
    public List<senador> getSenador() {


        return this.senadorRepository.findAll();

    }

    public ResponseEntity<Object> addNewSenador(senador senador) {
        Optional <senador> res = senadorRepository.findSenadorByNombre(senador.getNombre());
        datos = new HashMap<>();


        //datos.put("nombre", senador.getNombre());

        if(res.isPresent() && senador.getId() == 0 ){
            datos.put("error", true);
            datos.put("mensaje", "El senador ya existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        datos.put("mensaje", "El senador ha sido creado");

        if(senador.getId() != 0){
            datos.put("mensaje", "El senador ha sido Modificado");
        }

        senadorRepository.save(senador);
        datos.put("data", senador);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteSenador(Long senadorId) {
        datos = new HashMap<>();
        boolean exists = this.senadorRepository.existsById(senadorId);
        if(!exists){
            datos.put("error", true);
            datos.put("mensaje", "El senador no existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.NOT_FOUND
            );
        }
        this.senadorRepository.deleteById(senadorId);
        datos.put("mensaje", "El senador ha sido eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }
}
