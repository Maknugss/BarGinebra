package com.barginebra.repository;

import com.barginebra.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaDao extends JpaRepository<Mesa, Integer> {

    List<Mesa> findById(int id);
}
