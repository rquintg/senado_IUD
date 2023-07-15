package com.crud.CongresoIUD_DAO.service.impl;


import com.crud.CongresoIUD_DAO.dto.request.PartidoPoliticoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.PartidoPoliticoDTO;
import com.crud.CongresoIUD_DAO.model.PartidoPolitico;
import com.crud.CongresoIUD_DAO.repository.IpartidoPoliticoRepository;
import com.crud.CongresoIUD_DAO.service.iface.IPartidoPoliticoService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults (level = AccessLevel.PRIVATE)
public class PartidoPoliticoServiceImpl implements IPartidoPoliticoService {

    IpartidoPoliticoRepository partidoPoliticoRepository;

    @Autowired
    public PartidoPoliticoServiceImpl(IpartidoPoliticoRepository partidoPoliticoRepository){
        this.partidoPoliticoRepository = partidoPoliticoRepository;
    }

    @Override
    public List<PartidoPoliticoDTO> findAll(){
        List < PartidoPolitico > partidos = partidoPoliticoRepository.findAll();

        return partidos.stream().map(partido -> PartidoPoliticoDTO.builder()
                .id(partido.getId())
                .nombre(partido.getNombre())
                .descripcion(partido.getDescripcion())
                .build()).collect(Collectors.toList());

    }

    @Override
    public PartidoPoliticoDTO savePartido(PartidoPoliticoDTORequest partidoPoliticoDTORequest){

        PartidoPolitico partidoPolitico;

        partidoPolitico = partidoPoliticoRepository.findPartidoPoliticoByNombre(partidoPoliticoDTORequest.getNombre());

        if(partidoPolitico == null) {
            partidoPolitico = new PartidoPolitico();
            partidoPolitico.setNombre(partidoPoliticoDTORequest.getNombre());
            partidoPolitico.setDescripcion(partidoPoliticoDTORequest.getDescripcion());
            partidoPoliticoRepository.save(partidoPolitico);
        }

        return PartidoPoliticoDTO.builder()
                .id(partidoPolitico.getId())
                .nombre(partidoPolitico.getNombre())
                .descripcion(partidoPolitico.getDescripcion())
                .build();
    }



}
