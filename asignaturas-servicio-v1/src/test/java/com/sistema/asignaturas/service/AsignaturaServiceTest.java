package com.sistema.asignaturas.service;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.repository.AsignaturaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AsignaturaServiceTest {

    @Mock
    private AsignaturaRepository repo;

    @InjectMocks
    private AsignaturaService service;

    @Test
    void testListar() {
        Asignatura a1 = new Asignatura();
        a1.setId(1L);
        a1.setNombre("Matemáticas");

        Asignatura a2 = new Asignatura();
        a2.setId(2L);
        a2.setNombre("Historia");

        when(repo.findAll()).thenReturn(List.of(a1, a2));

        List<Asignatura> resultado = service.listar();

        assertEquals(2, resultado.size());
        assertEquals("Matemáticas", resultado.get(0).getNombre());
    }

    @Test
    void testBuscarPorId() {
        Asignatura a = new Asignatura();
        a.setId(1L);
        a.setNombre("Física");

        when(repo.findById(1L)).thenReturn(Optional.of(a));

        Optional<Asignatura> resultado = service.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Física", resultado.get().getNombre());
    }
}