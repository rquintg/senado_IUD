package com.crud.CongresoIUD_DAO.service.iface;

import com.crud.CongresoIUD_DAO.dto.request.ProyectoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.ProyectoDTO;


import java.util.List;

public interface IProyectoService {

    List<ProyectoDTO> findAll();

    String saveProyecto (ProyectoDTORequest proyectoDTORequest);

    String update (ProyectoDTORequest proyectoDTORequest, int proyectoId);

   String deleteProyecto (Long id);


}
