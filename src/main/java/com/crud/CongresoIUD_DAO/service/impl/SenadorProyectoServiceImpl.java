package com.crud.CongresoIUD_DAO.service.impl;

import com.crud.CongresoIUD_DAO.dto.request.SenadorProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorProyectoDTO;
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

        return senadorProyecto.stream().map(senadorproyecto -> SenadorProyectoDTO.builder()
                .id(senadorproyecto.getId())
                .voto(senadorproyecto.getVoto())
                .senador_id(String.valueOf(senadorproyecto.getSenador_id()))
                .proyecto_id(String.valueOf(senadorproyecto.getProyecto_id()))
                .build()).collect(Collectors.toList());
    }

    @Override
    public SenadorProyectoDTO saveSenadorProyecto(SenadorProyectoDTORequest senadorProyectoDTORequest) {

        SenadorProyecto senadorProyecto;


        //senadorProyecto = senadorProyectoRepository.findSenadorProyectoByVoto(senadorProyectoDTORequest.getSenador_id().getId());
        //senadorProyecto = senadorProyectoRepository.findById(senadorProyectoDTORequest.getProyecto_id().getId());

        Optional<SenadorProyecto> senador = this.senadorProyectoRepository.findById(senadorProyectoDTORequest.getSenador_id().getId());
        Optional<SenadorProyecto> proyecto = this.senadorProyectoRepository.findById(senadorProyectoDTORequest.getProyecto_id().getId());


        //1
        if (senador.isPresent()  && proyecto.isPresent()) {
            return null;
        } else {
            senadorProyecto = new SenadorProyecto();
            senadorProyecto.setVoto(senadorProyectoDTORequest.getVoto());
            senadorProyecto.setProyecto_id(senadorProyectoDTORequest.getProyecto_id());
            senadorProyecto.setSenador_id(senadorProyectoDTORequest.getSenador_id());
            senadorProyectoRepository.save(senadorProyecto);

            return SenadorProyectoDTO.builder()
                    .id(senadorProyecto.getId())
                    .voto(senadorProyecto.getVoto())
                    .proyecto_id(String.valueOf(senadorProyecto.getProyecto_id()))
                    .senador_id(String.valueOf(senadorProyecto.getSenador_id())).build();

        }


            /**if (senadorProyecto == null){
             senadorProyecto = new SenadorProyecto();
             senadorProyecto.setVoto(senadorProyectoDTORequest.getVoto());
             senadorProyecto.setProyecto_id(senadorProyectoDTORequest.getProyecto_id());
             senadorProyecto.setSenador_id(senadorProyectoDTORequest.getSenador_id());
             senadorProyectoRepository.save(senadorProyecto);
             }
             return SenadorProyectoDTO.builder()
             .id(senadorProyecto.getId())
             .voto(senadorProyecto.getVoto())
             .proyecto_id(String.valueOf(senadorProyecto.getProyecto_id()))
             .senador_id(String.valueOf(senadorProyecto.getSenador_id()))
             .build();
             **/

        }

        @Override
        public void update (SenadorProyectoDTORequest senadorProyectoDTORequest,int senadorProyectoId){

            Optional<SenadorProyecto> senadorProyectos = this.senadorProyectoRepository.findById(Long.valueOf(senadorProyectoId));
            SenadorProyecto senadorproyecto = senadorProyectos.get();
            senadorproyecto.setVoto(senadorProyectoDTORequest.getVoto());
            senadorproyecto.setProyecto_id(senadorProyectoDTORequest.getProyecto_id());
            senadorproyecto.setSenador_id(senadorProyectoDTORequest.getSenador_id());

            this.senadorProyectoRepository.save(senadorproyecto);
        }
        @Override
        public SenadorProyectoDTO deleteSenadorProyecto (Long id){
            senadorProyectoRepository.deleteById(id);
            return SenadorProyectoDTO.builder().build();
        }
    }


