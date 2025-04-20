package com.sistema.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenInterceptor extends OncePerRequestFilter {

    private final AuthClient authClient;

    public TokenInterceptor(AuthClient authClient) {
        this.authClient = authClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("🟣 SE EJECUTA EL INTERCEPTOR O NO???");

        String authHeader = request.getHeader("Authorization");
        System.out.println("👉 Token recibido en interceptor: " + authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                var respuesta = authClient.validarTokenYRol(authHeader);
                System.out.println("✅ Respuesta del microservicio auth: " + respuesta.getBody());
                filterChain.doFilter(request, response);
                return;
            } catch (Exception e) {
                System.out.println("❌ Error al validar el token: " + e.getMessage());
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Token inválido");
                return;
            }
        }

        System.out.println("⚠️ No se envió token o está mal formado");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write("Token requerido");
    }
}