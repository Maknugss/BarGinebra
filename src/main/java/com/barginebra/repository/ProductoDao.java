package com.barginebra.repository;

import com.barginebra.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ProductoDao extends JpaRepository<Producto, Integer> {

    List<Producto> findById(int id);
}
