package com.sistema.asignaturas.repository;

import com.sistema.asignaturas.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
