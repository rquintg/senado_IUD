package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.senador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface senadorRepository extends JpaRepository<senador, Long> {

    // @Query("SELECT s FROM senador s WHERE s.nombre = ?1")
    Optional<senador> findSenadorByNombre(String nombre);
}
