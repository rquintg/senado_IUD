package com.crud.CongresoIUD_DAO.service.iface;

import com.crud.CongresoIUD_DAO.dto.request.SenadorDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.SenadorDTO;

import java.util.List;

public interface ISenadorService {

    List<SenadorDTO> findAll();
    
    SenadorDTO saveSenador(SenadorDTORequest senadorDTORequest);

    SenadorDTO deleteSenador(long id);


}
