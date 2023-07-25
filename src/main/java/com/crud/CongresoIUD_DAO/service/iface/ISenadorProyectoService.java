package com.crud.CongresoIUD_DAO.service.iface;


import com.crud.CongresoIUD_DAO.dto.request.SenadorProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorProyectoDTO;
import java.util.List;

public interface ISenadorProyectoService {

    List<SenadorProyectoDTO> findAll();
    SenadorProyectoDTO saveSenadorProyecto(SenadorProyectoDTORequest senadorProyectoDTORequest);

    void update (SenadorProyectoDTORequest senadorProyectoDTORequest, int senadorProyectoId);

    SenadorProyectoDTO deleteSenadorProyecto(Long id);



   // SenadorProyectoDTO getSenadorAndProyectoById(Senador senador_id, Proyecto proyecto_id);
}
