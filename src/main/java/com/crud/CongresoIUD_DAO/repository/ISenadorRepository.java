package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.Senador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISenadorRepository extends JpaRepository<Senador, Long> {

    Senador findSenadorByNombre(String nombre);

    Optional<Senador> findByNombreIgnoreCase(String nuevoNombre);
    //List<Senador> findAllSenador();



}
