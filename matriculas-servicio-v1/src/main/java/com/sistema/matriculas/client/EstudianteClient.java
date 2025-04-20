package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "estudiantes-service", url = "http://localhost:8080")
public interface EstudianteClient {

    @GetMapping("/usuarios/{id}")
    Object obtenerEstudiantePorId(
            @PathVariable("id") Long id,
            @RequestHeader("Authorization") String token);
}