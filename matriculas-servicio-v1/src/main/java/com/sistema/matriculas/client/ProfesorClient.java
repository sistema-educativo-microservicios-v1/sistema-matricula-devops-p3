package com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "profesores-service", url = "http://localhost:8080")
public interface ProfesorClient {

    @GetMapping("/usuarios/{id}")
    Object obtenerProfesorPorId(
            @PathVariable("id") Long id,
            @RequestHeader("Authorization") String token);
}