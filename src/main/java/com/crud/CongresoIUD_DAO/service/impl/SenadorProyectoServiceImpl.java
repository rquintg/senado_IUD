package com.crud.CongresoIUD_DAO.service.impl;

import com.crud.CongresoIUD_DAO.dto.request.SenadorProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorProyectoDTO;
import com.crud.CongresoIUD_DAO.exceptions.UserNotFoundException;
import com.crud.CongresoIUD_DAO.model.Proyecto;
import com.crud.CongresoIUD_DAO.model.SenadorProyecto;
import com.crud.CongresoIUD_DAO.repository.ISenadorProyectoRepository;
import com.crud.CongresoIUD_DAO.service.iface.ISenadorProyectoService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenadorProyectoServiceImpl implements ISenadorProyectoService {


    ISenadorProyectoRepository senadorProyectoRepository;

    @Autowired
    public SenadorProyectoServiceImpl(ISenadorProyectoRepository senadorProyectoRepository) {
        this.senadorProyectoRepository = senadorProyectoRepository;
    }

    @Override
    public List<SenadorProyectoDTO> findAll() {

        List<SenadorProyecto> senadorProyecto = senadorProyectoRepository.findAll();

        if(senadorProyecto.isEmpty()) throw new UserNotFoundException("No hay votos en la base de datos");

        return senadorProyecto.stream().map(senadorproyecto -> SenadorProyectoDTO.builder()
                .id(senadorproyecto.getId())
                .voto(senadorproyecto.getVoto())
                .senador(String.valueOf(senadorproyecto.getSenador()))
                .proyecto(String.valueOf(senadorproyecto.getProyecto()))
                .build()).collect(Collectors.toList());
    }

    @Override
    public SenadorProyectoDTO saveSenadorProyecto(SenadorProyectoDTORequest senadorProyectoDTORequest) {

        SenadorProyecto senadorProyecto;

        SenadorProyecto senadorProyecto1 = senadorProyectoRepository.findBySenadorIdAndProyectoId
                (senadorProyectoDTORequest.getSenador().getId(),senadorProyectoDTORequest.getProyecto().getId());

        if (senadorProyecto1 != null) {
                throw new IllegalArgumentException("el " + senadorProyectoDTORequest.getSenador().getNombre() +
                        "ya voto el proyecto" +senadorProyectoDTORequest.getProyecto().getNombre());
        } else {
            senadorProyecto = new SenadorProyecto();
            senadorProyecto.setVoto(senadorProyectoDTORequest.getVoto());
            senadorProyecto.setProyecto(senadorProyectoDTORequest.getProyecto());
            senadorProyecto.setSenador(senadorProyectoDTORequest.getSenador());
            senadorProyectoRepository.save(senadorProyecto);

            return SenadorProyectoDTO.builder()
                    .id(senadorProyecto.getId())
                    .voto(senadorProyecto.getVoto())
                    .proyecto(String.valueOf(senadorProyecto.getProyecto()))
                    .senador(String.valueOf(senadorProyecto.getSenador())).build();


        }

        }

        @Override
        public void update (SenadorProyectoDTORequest senadorProyectoDTORequest,int senadorProyectoId){

            Optional<SenadorProyecto> senadorProyectos = this.senadorProyectoRepository.findById(Long.valueOf(senadorProyectoId));
            if (senadorProyectos.isEmpty()) {
                throw new IllegalArgumentException("No existe relacion de voto con id " + senadorProyectoId + " en la base de datos");
            }
            SenadorProyecto senadorproyecto = senadorProyectos.get();
            senadorproyecto.setVoto(senadorProyectoDTORequest.getVoto());
            senadorproyecto.setProyecto(senadorProyectoDTORequest.getProyecto());
            senadorproyecto.setSenador(senadorProyectoDTORequest.getSenador());

            this.senadorProyectoRepository.save(senadorproyecto);
        }
        @Override
        public SenadorProyectoDTO deleteSenadorProyecto (Long id){
            Optional<SenadorProyecto> senadoPproyecto = senadorProyectoRepository.findById(id);

            if (senadoPproyecto.isEmpty()) {
                throw new UserNotFoundException("No existe el id " + id + " en la base de datos");
            }else {
                senadorProyectoRepository.deleteById(id);
            }
            return SenadorProyectoDTO.builder().build();
        }
    }


