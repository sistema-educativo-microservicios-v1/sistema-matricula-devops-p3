package com.sistema.asignaturas.service;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repo;

    public AsignaturaService(AsignaturaRepository repo) {
        this.repo = repo;
    }

    public List<Asignatura> listar() {
        return repo.findAll();
    }

    public Optional<Asignatura> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Asignatura guardar(Asignatura asignatura) {
        return repo.save(asignatura);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
