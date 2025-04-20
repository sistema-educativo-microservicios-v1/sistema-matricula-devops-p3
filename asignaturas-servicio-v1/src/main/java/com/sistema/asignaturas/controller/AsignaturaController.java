package com.sistema.asignaturas.controller;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.service.AsignaturaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asignatura> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asignatura guardar(@RequestBody Asignatura asignatura) {
        return service.guardar(asignatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizar(@PathVariable Long id, @RequestBody Asignatura datosActualizados) {
        return service.buscarPorId(id)
                .map(asignaturaExistente -> {
                    asignaturaExistente.setNombre(datosActualizados.getNombre());
                    asignaturaExistente.setDescripcion(datosActualizados.getDescripcion());
                    return ResponseEntity.ok(service.guardar(asignaturaExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(asignatura -> {
                    service.eliminar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
