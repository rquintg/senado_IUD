package com.crud.CongresoIUD_DAO.service.impl;

import com.crud.CongresoIUD_DAO.dto.request.SenadorDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorDTO;
import com.crud.CongresoIUD_DAO.model.Senador;
import com.crud.CongresoIUD_DAO.repository.ISenadorRepository;
import com.crud.CongresoIUD_DAO.service.iface.ISenadorService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
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

        return senadores.stream().map(senador -> SenadorDTO.builder()
                .id(senador.getId())
                .nombre(senador.getNombre())
                .departamento(senador.getDepartamento())
                .fecha(String.valueOf(senador.getFecha()))
                .partido_politico_id(String.valueOf(senador.getPartido_politico_id()))
                .build()).collect(Collectors.toList());
    }

    @Override
    public SenadorDTO saveSenador(SenadorDTORequest senadorDTORequest) {

        Senador senador;

        senador = senadorRepository.findSenadorByNombre(senadorDTORequest.getNombre());

        if(senador == null){
            senador = new Senador();
            senador.setNombre(senadorDTORequest.getNombre());
            senador.setDepartamento(senadorDTORequest.getDepartamento());
            senador.setFecha(senadorDTORequest.getFecha());
            senador.setPartido_politico_id(senadorDTORequest.getPartido_politico_id());
            senadorRepository.save(senador);
        } else {
            senador.setNombre(senadorDTORequest.getNombre());
            senador.setDepartamento(senadorDTORequest.getDepartamento());
            senador.setFecha(senadorDTORequest.getFecha());
            senador.setPartido_politico_id(senadorDTORequest.getPartido_politico_id());
            senadorRepository.save(senador);
        }
        return  SenadorDTO.builder()
                .id(senador.getId())
                .nombre(senador.getNombre())
                .departamento(senador.getDepartamento())
                .fecha(String.valueOf(senador.getFecha()))
                .partido_politico_id(String.valueOf(senador.getPartido_politico_id()))
                .build();
    }

    @Override
    public SenadorDTO deleteSenador(long id) {

        senadorRepository.deleteById(id);
        return SenadorDTO.builder().build();
    }





}
