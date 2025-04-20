package com.sistema.matriculas.service;

import com.sistema.matriculas.client.EstudianteClient;
import com.sistema.matriculas.client.MateriaClient;
import com.sistema.matriculas.client.ProfesorClient;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.model.MatriculaConObjetos;
import com.sistema.matriculas.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MatriculaService {

    private final MatriculaRepository repository;
    private final EstudianteClient estudianteClient;
    private final ProfesorClient profesorClient;
    private final MateriaClient materiaClient;

    public MatriculaService(MatriculaRepository repository, EstudianteClient estudianteClient,
            ProfesorClient profesorClient, MateriaClient materiaClient) {
        this.repository = repository;
        this.estudianteClient = estudianteClient;
        this.profesorClient = profesorClient;
        this.materiaClient = materiaClient;
    }

    public Matricula asignar(Matricula matricula, String token) {
        // Validación de existencia
        estudianteClient.obtenerEstudiantePorId(matricula.getEstudianteId(), token);
        profesorClient.obtenerProfesorPorId(matricula.getProfesorId(), token);
        materiaClient.obtenerMateriaPorId(matricula.getMateriaId(), token);

        return repository.save(matricula);
    }

    public void desasignar(Long id) {
        repository.deleteById(id);
    }

    public List<Map<String, Object>> listar(String token) {
        return repository.findAll().stream().map(m -> {
            Map<String, Object> datos = new HashMap<>();
            datos.put("id", m.getId());
            datos.put("estudiante", estudianteClient.obtenerEstudiantePorId(m.getEstudianteId(), token));
            datos.put("profesor", profesorClient.obtenerProfesorPorId(m.getProfesorId(), token));
            datos.put("materia", materiaClient.obtenerMateriaPorId(m.getMateriaId(), token));
            return datos;
        }).collect(Collectors.toList());
    }
}
