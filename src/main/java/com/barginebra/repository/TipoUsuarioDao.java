package com.barginebra.repository;

import com.barginebra.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioDao extends JpaRepository<TipoUsuario, Integer> {
}
