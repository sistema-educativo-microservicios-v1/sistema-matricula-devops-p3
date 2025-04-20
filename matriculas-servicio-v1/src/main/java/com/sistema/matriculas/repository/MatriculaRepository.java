package com.sistema.matriculas.repository;

import com.sistema.matriculas.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
