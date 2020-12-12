package com.cenfotec.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cenfotec.examen.entities.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
