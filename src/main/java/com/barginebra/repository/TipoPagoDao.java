package com.barginebra.repository;

import com.barginebra.model.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoPagoDao extends JpaRepository<TipoPago, Integer> {

    List<TipoPago> findById(int id);
}
