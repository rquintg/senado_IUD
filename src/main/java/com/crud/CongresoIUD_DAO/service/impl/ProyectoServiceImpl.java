package com.crud.CongresoIUD_DAO.service.impl;
import com.crud.CongresoIUD_DAO.dto.request.ProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.ProyectoDTO;
import com.crud.CongresoIUD_DAO.exceptions.UserNotFoundException;
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

        if(proyectos.isEmpty()) throw new UserNotFoundException("No hay Proyectos en la base de datos");

        return proyectos.stream().map(proyecto -> ProyectoDTO.builder()
                .id(proyecto.getId())
                .nombre(proyecto.getNombre())
                .descripcion(proyecto.getDescripcion())
                .build()).collect(Collectors.toList());

    }

    @Override
    public String saveProyecto (ProyectoDTORequest proyectoDTORequest) {

        Proyecto proyecto ;
        proyecto = proyectoRepository.findProyectoByNombre(proyectoDTORequest.getNombre());

        Proyecto existingProyecto = proyectoRepository.findProyectoByNombre(proyectoDTORequest.getNombre());

        if (existingProyecto != null) {
            throw new IllegalArgumentException("Ya existe el proyecto " + proyectoDTORequest.getNombre() + " en la base de datos");
        }

        if (proyecto == null) {
            proyecto = new Proyecto();
            proyecto.setNombre(proyectoDTORequest.getNombre());
            proyecto.setDescripcion(proyectoDTORequest.getDescripcion());
            proyectoRepository.save(proyecto);
        }
        return "Se ha guardado el proyecto " + proyectoDTORequest.getNombre() + " con exito";
    }

    @Override
    public String update (ProyectoDTORequest proyectoDTORequest, int proyectoId) {
        // Verificar que el proyecto a actualizar existe
        Optional<Proyecto> proyectoOptional = this.proyectoRepository.findById(Long.valueOf(proyectoId));

        if (proyectoOptional.isEmpty()) {
            throw new IllegalArgumentException("No existe el proyecto con id " + proyectoId + " en la base de datos");
        }

        Proyecto proyecto = proyectoOptional.get();

        proyecto.setNombre(proyectoDTORequest.getNombre());
        proyecto.setDescripcion(proyectoDTORequest.getDescripcion());
        proyectoRepository.save(proyecto);

        return "Se ha actualizado el proyecto con id " + proyectoId + " en la base de datos";

    }

    @Override
    public String deleteProyecto (Long id){
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);

        if (proyecto.isEmpty()) {
            throw new UserNotFoundException("No existe el proyecto con id " + id + " en la base de datos");
        }else {
            proyectoRepository.deleteById(id);
        }

        return "Se ha eliminado el proyecto con id " + id + " con exito";

    }


}
