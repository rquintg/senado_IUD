package com.crud.CongresoIUD_DAO.repository;

import com.crud.CongresoIUD_DAO.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
