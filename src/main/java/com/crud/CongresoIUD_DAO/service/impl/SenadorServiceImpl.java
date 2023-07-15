package com.crud.CongresoIUD_DAO.service.impl;

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
            // pendiente de revisar a ver si funciona el map
        return senadores.stream().map(senador -> SenadorDTO.builder()
                .id(senador.getId())
                .nombre(senador.getNombre())
                .departamento(senador.getDepartamento())
                .fecha(String.valueOf(senador.getFecha()))
                .partido_politico_id(String.valueOf(senador.getPartido_politico_id()))
                .build()).collect(Collectors.toList());
    }



}
