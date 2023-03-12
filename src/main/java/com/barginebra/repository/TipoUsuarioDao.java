package com.barginebra.repository;

import com.barginebra.model.TipoUsuario;
import com.barginebra.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoUsuarioDao extends JpaRepository<TipoUsuario, Integer> {
    List<TipoUsuario> findById(int idTipoUsuario);

}
