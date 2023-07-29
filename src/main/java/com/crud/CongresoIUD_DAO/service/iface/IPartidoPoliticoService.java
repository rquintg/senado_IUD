package com.crud.CongresoIUD_DAO.service.iface;

import com.crud.CongresoIUD_DAO.dto.request.PartidoPoliticoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.PartidoPoliticoDTO;

import java.util.List;

public interface IPartidoPoliticoService {

    List<PartidoPoliticoDTO> findAll();

    String savePartido(PartidoPoliticoDTORequest partidoPoliticoDTORequest);

    String update (PartidoPoliticoDTORequest partidoPoliticoDTORequest, int partidoId);

    String deletePartido(Long id);
}
