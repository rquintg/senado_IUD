package com.crud.CongresoIUD_DAO.service.impl;


import com.crud.CongresoIUD_DAO.dto.request.PartidoPoliticoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.PartidoPoliticoDTO;
import com.crud.CongresoIUD_DAO.model.PartidoPolitico;
import com.crud.CongresoIUD_DAO.repository.IPartidoPoliticoRepository;
import com.crud.CongresoIUD_DAO.service.iface.IPartidoPoliticoService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@FieldDefaults (level = AccessLevel.PRIVATE)
public class PartidoPoliticoServiceImpl implements IPartidoPoliticoService {

    IPartidoPoliticoRepository partidoPoliticoRepository;

    @Autowired
    public PartidoPoliticoServiceImpl(IPartidoPoliticoRepository partidoPoliticoRepository){
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

    @Override
    public void update(PartidoPoliticoDTORequest partidoPoliticoDTORequest, int partidoId) {
        Optional<PartidoPolitico> partidos = this.partidoPoliticoRepository.findById(Long.valueOf(partidoId));//consultamos el ID
        PartidoPolitico partido = partidos.get();//se cual es el senador
        //ACtualizo los datos del senador
        partido.setNombre(partidoPoliticoDTORequest.getNombre());
        partido.setDescripcion(partidoPoliticoDTORequest.getDescripcion());

        //guardo los datos actualizados
        this.partidoPoliticoRepository.save(partido);
    }

    @Override
    public PartidoPoliticoDTO deletePartido(Long id){
        partidoPoliticoRepository.deleteById(id);
        return  PartidoPoliticoDTO.builder().build();
    }
}

