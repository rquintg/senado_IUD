package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.Senador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISenadorRepository extends JpaRepository<Senador, Long> {

    Senador findSenadorByNombre(String nombre);
    //List<Senador> findAllSenador();



}
