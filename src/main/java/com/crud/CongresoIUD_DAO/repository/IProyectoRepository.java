package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProyectoRepository extends JpaRepository <Proyecto, Long>  {

    Proyecto findProyectoByNombre(String nombre);

}
