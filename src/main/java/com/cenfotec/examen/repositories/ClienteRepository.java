package com.cenfotec.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cenfotec.examen.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
