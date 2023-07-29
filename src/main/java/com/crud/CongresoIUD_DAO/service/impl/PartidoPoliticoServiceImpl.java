package com.crud.CongresoIUD_DAO.service.impl;


import com.crud.CongresoIUD_DAO.dto.request.PartidoPoliticoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.PartidoPoliticoDTO;
import com.crud.CongresoIUD_DAO.exceptions.UserNotFoundException;
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

        if(partidos.isEmpty()) throw new UserNotFoundException("No hay partido politico en la base de datos");

        return partidos.stream().map(partido -> PartidoPoliticoDTO.builder()
                .id(partido.getId())
                .nombre(partido.getNombre())
                .descripcion(partido.getDescripcion())
                .build()).collect(Collectors.toList());
    }

    @Override
    public String savePartido(PartidoPoliticoDTORequest partidoPoliticoDTORequest){

        PartidoPolitico partidoPolitico;

        partidoPolitico = partidoPoliticoRepository.findPartidoPoliticoByNombre(partidoPoliticoDTORequest.getNombre());
        PartidoPolitico existingPartido = partidoPoliticoRepository.findPartidoPoliticoByNombre(partidoPoliticoDTORequest.getNombre());

        if (existingPartido != null) {
            throw new IllegalArgumentException("Ya existe el partido politico " + partidoPoliticoDTORequest.getNombre() + " en la base de datos");

        }

        if (partidoPolitico == null) {
            partidoPolitico = new PartidoPolitico();
            partidoPolitico.setNombre(partidoPoliticoDTORequest.getNombre());
            partidoPolitico.setDescripcion(partidoPoliticoDTORequest.getDescripcion());
            partidoPoliticoRepository.save(partidoPolitico);

        }  return "Se ha guardado el partido politico " + partidoPoliticoDTORequest.getNombre() + " con exito";
    }
    @Override
    public String update (PartidoPoliticoDTORequest partidoPoliticoDTORequest, int partidoId) {

        Optional<PartidoPolitico> partidoPolitico = this.partidoPoliticoRepository.findById(Long.valueOf(partidoId));

        if(partidoPolitico.isEmpty()){
            throw new IllegalArgumentException("No existe el senador con id " + partidoId + " en la base de datos");
        }

        PartidoPolitico partidoPolitico1 = partidoPolitico.get();
        partidoPolitico1.setNombre(partidoPoliticoDTORequest.getNombre());
        partidoPolitico1.setDescripcion(partidoPoliticoDTORequest.getDescripcion());

        this.partidoPoliticoRepository.save(partidoPolitico1);

        return "Se ha actualizado el senador con id " + partidoId + " en la base de datos";

    }

    @Override
    public String deletePartido(Long id){

        Optional<PartidoPolitico> partidoPolitico = partidoPoliticoRepository.findById(id);

        if (partidoPolitico.isEmpty()) {
            throw new UserNotFoundException("No existe el partido politico con id " + id + " en la base de datos");
        }else{
            partidoPoliticoRepository.deleteById(id);
        }
        return "Se ha eliminado el partido politico con id " + id + " con exito";
    }
}

