package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.PartidoPolitico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidoPoliticoRepository extends JpaRepository<PartidoPolitico, Long> {

    PartidoPolitico findPartidoPoliticoByNombre(String nombre);
}
