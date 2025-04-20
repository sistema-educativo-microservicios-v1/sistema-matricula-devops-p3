package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "materias-service", url = "http://localhost:8081")
public interface MateriaClient {

    @GetMapping("/asignaturas/{id}")
    Object obtenerMateriaPorId(
            @PathVariable("id") Long id,
            @RequestHeader("Authorization") String token);
}