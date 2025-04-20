package com.sistema.matriculas.controller;

import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.model.MatriculaConObjetos;
import com.sistema.matriculas.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    // Desasignar (eliminar) una matrícula por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desasignar(@PathVariable Long id) {
        service.desasignar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> listar(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.listar(token));
    }

    @PostMapping
    public ResponseEntity<Matricula> asignar(@RequestBody Matricula matricula,
            @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.asignar(matricula, token));
    }

}
