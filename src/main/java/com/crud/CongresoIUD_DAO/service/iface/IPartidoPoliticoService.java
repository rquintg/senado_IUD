package com.crud.CongresoIUD_DAO.service.iface;

import com.crud.CongresoIUD_DAO.dto.request.PartidoPoliticoDTORequest;
import com.crud.CongresoIUD_DAO.dto.response.PartidoPoliticoDTO;

import java.util.List;

public interface IPartidoPoliticoService {

    List<PartidoPoliticoDTO> findAll();

    PartidoPoliticoDTO savePartido(PartidoPoliticoDTORequest partidoPoliticoDTORequest);

    void update (PartidoPoliticoDTORequest partidoPoliticoDTORequest, int partidoId);

    PartidoPoliticoDTO deletePartido(Long id);
}
