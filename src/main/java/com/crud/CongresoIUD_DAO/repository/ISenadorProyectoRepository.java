package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.SenadorProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ISenadorProyectoRepository extends JpaRepository<SenadorProyecto, Long> {

    // SenadorProyecto findSenadorProyectoByVoto(Long id);


}
