package com.crud.CongresoIUD_DAO.service.impl;

import com.crud.CongresoIUD_DAO.dto.request.SenadorDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorDTO;
import com.crud.CongresoIUD_DAO.exceptions.UserNotFoundException;
import com.crud.CongresoIUD_DAO.model.Senador;
import com.crud.CongresoIUD_DAO.repository.ISenadorRepository;
import com.crud.CongresoIUD_DAO.service.iface.ISenadorService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorServiceImpl implements ISenadorService {


    ISenadorRepository senadorRepository;
    @Autowired
    public SenadorServiceImpl(ISenadorRepository senadorRepository) {
        this.senadorRepository = senadorRepository;
    }

    @Override
    public List<SenadorDTO> findAll() {

        List<Senador> senadores = senadorRepository.findAll();

        if(senadores.isEmpty()) throw new UserNotFoundException("No hay senadores en la base de datos");

        return senadores.stream().map(senador -> SenadorDTO.builder()
                .id(senador.getId())
                .nombre(senador.getNombre())
                .departamento(senador.getDepartamento())
                .fecha(String.valueOf(senador.getFecha()))
                .partido_politico_id(String.valueOf(senador.getPartido_politico_id()))
                .build()).collect(Collectors.toList());
    }

    @Override
    public String saveSenador(SenadorDTORequest senadorDTORequest)   {

        Senador senador;

        senador = senadorRepository.findSenadorByNombre(senadorDTORequest.getNombre());

        Senador existingSenador = senadorRepository.findSenadorByNombre(senadorDTORequest.getNombre());
        if (existingSenador != null) {
            throw new IllegalArgumentException("Ya existe el senador " + senadorDTORequest.getNombre() + " en la base de datos");
        }

        if (senador == null) {
            senador = new Senador();
            senador.setNombre(senadorDTORequest.getNombre());
            senador.setDepartamento(senadorDTORequest.getDepartamento());
            senador.setFecha(senadorDTORequest.getFecha());
            senador.setPartido_politico_id(senadorDTORequest.getPartido_politico_id());
            senadorRepository.save(senador);
        }
        return "Se ha guardado el senador " + senadorDTORequest.getNombre() + " con exito";
    }

    @Override
    public String update (SenadorDTORequest senadorDTORequest, int senadorId) {
        Optional<Senador> senadores = this.senadorRepository.findById(Long.valueOf(senadorId));

        if(senadores.isEmpty()){
            throw new IllegalArgumentException("No existe el senador con id " + senadorId + " en la base de datos");
        }

            Senador senador = senadores.get();
            senador.setNombre(senadorDTORequest.getNombre());
            senador.setDepartamento(senadorDTORequest.getDepartamento());
            senador.setFecha(senadorDTORequest.getFecha());
            senador.setPartido_politico_id(senadorDTORequest.getPartido_politico_id());

            this.senadorRepository.save(senador);

        return "Se ha actualizado el senador con id " + senadorId + " en la base de datos";


    }


    @Override
    public String deleteSenador(long id) {

        Optional<Senador> senador = senadorRepository.findById(id);

        if (senador.isEmpty()) {
            throw new UserNotFoundException("No existe el senador con id " + id + " en la base de datos");
        }else {
            senadorRepository.deleteById(id);
        }

        return "Se ha eliminado el senador con id " + id + " con exito";
    }





}
