package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.Senador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISenadorRepository extends JpaRepository<Senador, Long> {

        // Optional<senador> findSenadorByNombre(String nombre);

    //List<Senador> findAllSenador();
}
