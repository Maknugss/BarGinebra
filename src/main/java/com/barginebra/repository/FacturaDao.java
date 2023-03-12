package com.barginebra.repository;

import com.barginebra.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaDao extends JpaRepository<Factura, Integer> {

    List<Factura> findById(int id);
}
