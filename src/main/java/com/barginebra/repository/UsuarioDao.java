package com.barginebra.repository;

import com.barginebra.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

    List<Usuario> findById(int idUsuario);

}
