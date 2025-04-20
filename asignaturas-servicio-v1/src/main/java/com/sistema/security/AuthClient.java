package com.sistema.security;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "auth-service", url = "http://localhost:8080/auth")
public interface AuthClient {

    @GetMapping("/validate-token")
    ResponseEntity<Map<String, String>> validarTokenYRol(@RequestHeader("Authorization") String token);
}
