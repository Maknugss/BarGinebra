package com.barginebra.repository;

import com.barginebra.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDao extends JpaRepository<Pedido, Integer> {

    List<Pedido> findById(int id);
}
