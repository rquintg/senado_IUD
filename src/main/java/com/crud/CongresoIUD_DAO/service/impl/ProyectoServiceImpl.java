package com.crud.CongresoIUD_DAO.service.impl;
import com.crud.CongresoIUD_DAO.dto.request.ProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.ProyectoDTO;
import com.crud.CongresoIUD_DAO.model.Proyecto;
import com.crud.CongresoIUD_DAO.repository.IProyectoRepository;
import com.crud.CongresoIUD_DAO.service.iface.IProyectoService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProyectoServiceImpl implements IProyectoService {

    IProyectoRepository proyectoRepository;
    @Autowired
    public ProyectoServiceImpl (IProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;

    }

    @Override
    public List<ProyectoDTO> findAll() {

        List<Proyecto> proyectos = proyectoRepository.findAll();

        return proyectos.stream().map(proyecto -> ProyectoDTO.builder()
                .id(proyecto.getId())
                .nombre(proyecto.getNombre())
                .descripcion(proyecto.getDescripcion())
                .build()).collect(Collectors.toList());

    }

        @Override
    public ProyectoDTO saveProyecto (ProyectoDTORequest proyectoDTORequest){

        Proyecto proyecto;

        proyecto = proyectoRepository.findProyectoByNombre(proyectoDTORequest.getNombre());

        if(proyecto == null) {
            proyecto = new Proyecto();
            proyecto.setNombre(proyectoDTORequest.getNombre());
            proyecto.setDescripcion(proyectoDTORequest.getDescripcion());
            proyectoRepository.save(proyecto);
        }

        return ProyectoDTO.builder()
                .id(proyecto.getId())
                .nombre(proyecto.getNombre())
                .descripcion(proyecto.getDescripcion())
                .build();
    }

    @Override
    public void update (ProyectoDTORequest proyectoDTORequest, int proyectoId) {
        Optional<Proyecto> proyectos = this.proyectoRepository.findById(Long.valueOf(proyectoId));
        Proyecto proyecto = proyectos.get();
        proyecto.setNombre(proyectoDTORequest.getNombre());
        proyecto.setDescripcion(proyectoDTORequest.getDescripcion());

        this.proyectoRepository.save(proyecto);
    }

    @Override
    public ProyectoDTO deleteProyecto (Long id){
        proyectoRepository.deleteById(id);
        return ProyectoDTO.builder().build();

    }


}
