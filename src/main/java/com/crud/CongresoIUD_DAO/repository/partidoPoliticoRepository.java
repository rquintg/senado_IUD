package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.partidoPolitico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface partidoPoliticoRepository extends JpaRepository<partidoPolitico, Long> {

    Optional<partidoPolitico> findPartidoPoliticoByNombre(String nombre);
}
