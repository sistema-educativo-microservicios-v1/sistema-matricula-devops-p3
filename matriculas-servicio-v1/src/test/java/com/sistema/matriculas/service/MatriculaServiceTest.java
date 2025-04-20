package com.sistema.matriculas.service;

import com.sistema.matriculas.client.EstudianteClient;
import com.sistema.matriculas.client.MateriaClient;
import com.sistema.matriculas.client.ProfesorClient;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.repository.MatriculaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MatriculaServiceTest {

    @Mock
    private MatriculaRepository repository;

    @Mock
    private EstudianteClient estudianteClient;

    @Mock
    private ProfesorClient profesorClient;

    @Mock
    private MateriaClient materiaClient;

    @InjectMocks
    private MatriculaService service;

    private Matricula matricula;
    private final String token = "fake-token";

    @BeforeEach
    void setup() {
        matricula = new Matricula();
        matricula.setId(1L);
        matricula.setEstudianteId(10L);
        matricula.setProfesorId(20L);
        matricula.setMateriaId(30L);
    }

    @Test
    void testAsignar() {
        // Mocks para validaciones
        when(estudianteClient.obtenerEstudiantePorId(10L, token)).thenReturn(new HashMap<>());
        when(profesorClient.obtenerProfesorPorId(20L, token)).thenReturn(new HashMap<>());
        when(materiaClient.obtenerMateriaPorId(30L, token)).thenReturn(new HashMap<>());
        when(repository.save(matricula)).thenReturn(matricula);

        Matricula resultado = service.asignar(matricula, token);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(repository).save(matricula);
    }

    @Test
    void testDesasignar() {
        service.desasignar(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void testListar() {
        when(repository.findAll()).thenReturn(List.of(matricula));
        when(estudianteClient.obtenerEstudiantePorId(10L, token)).thenReturn(Map.of("nombre", "Juan"));
        when(profesorClient.obtenerProfesorPorId(20L, token)).thenReturn(Map.of("nombre", "Prof. Ana"));
        when(materiaClient.obtenerMateriaPorId(30L, token)).thenReturn(Map.of("nombre", "Física"));

        List<Map<String, Object>> resultado = service.listar(token);

        assertEquals(1, resultado.size());
        assertEquals("Juan", ((Map<?, ?>) resultado.get(0).get("estudiante")).get("nombre"));
    }
}
