# 📚 Sistema Educativo Distribuido - DevOps Final

Este proyecto representa la evaluación final de la materia, integrando arquitectura de microservicios con enfoque DevOps.  
Incluye autenticación, gestión de usuarios, asignaturas y matrículas, con pruebas, monitoreo, CI/CD y despliegue en Docker Compose.

---

##  Arquitectura General

El sistema está compuesto por los siguientes microservicios:

| Microservicio           | Descripción                                          |
|------------------------|------------------------------------------------------|
| `auth-service`         | Registro, login, generación y validación de tokens JWT |
| `usuarios-servicio`    | Gestión de estudiantes y profesores                   |
| `asignaturas-service`  | CRUD de asignaturas/materias                          |
| `matriculas-service`   | Asignación de estudiantes y profesores a materias     |
| `eureka-server`        | Descubrimiento de servicios (Eureka)                  |
| `config-server`        | Centralización de propiedades desde GitHub            |
| `adminserver`          | Ruta protegida para ADMIN                             |
| `gateway`              | Pasarela de entrada a todos los servicios             |
| `prometheus` & `grafana` | Monitoreo de servicios                              |

---

## 📂 Estructura de Carpetas

```
/sistema-educativo/
├── auth-service/
├── usuarios-servicio/
├── asignaturas-service/
├── matriculas-service/
├── eureka-server/
├── config-server/
├── adminserver/
├── docker-compose.yml
├── .github/workflows/test.yml
└── README.md
```

---

## 🔐 Seguridad

- Los tokens JWT se generan en `auth-service`.
- Los endpoints están protegidos por roles (`ADMIN`, `USER`).
- Cada servicio que consume datos valida el token con `FeignClient`.

---

## 🔄 Comunicación entre microservicios

- `matriculas-service` se comunica con:
  - `usuarios-servicio` (estudiante y profesor)
  - `asignaturas-service` (materia)
- Se usan `@FeignClient` para llamadas entre servicios.

---

## ⚙️ Configuración y Eureka

- Todos los microservicios usan un `config-server` que carga las propiedades desde un repositorio en GitHub.
- `eureka-server` permite que los microservicios se registren y descubran dinámicamente.

---

## 📈 Monitoreo y Observabilidad

- Todos los servicios usan Spring Boot Actuator.
- Endpoints habilitados: `/actuator/health`, `/actuator/info`, `/actuator/metrics`
- Docker Compose incluye `Prometheus` y `Grafana` para visualización de métricas.

---

##  Pruebas Automáticas

- Cada microservicio incluye:
  - ✅ Al menos 2 pruebas unitarias con Mockito
  - ✅ 1 prueba de integración usando WebTestClient o SpringBootTest
- Integradas con GitHub Actions para ejecutarse en cada `push`.

---

## 🚀 CI/CD

- Pipeline definido en `.github/workflows/test.yml`
- Ejecuta automáticamente los tests al hacer `push` o `pull_request`
- Verifica la calidad del código antes del despliegue

---

## Test de asignaturas
![Imagen de WhatsApp 2025-04-20 a las 18 09 46_aef3d6cc](https://github.com/user-attachments/assets/83bf8b13-79b0-4f7f-aa71-203924d8dbb9)

## Test de matriculas
![Imagen de WhatsApp 2025-04-20 a las 18 10 45_948e71d7](https://github.com/user-attachments/assets/a63054b1-05c5-446b-8f01-564515bfdc83)

## Test de usuarios
![Imagen de WhatsApp 2025-04-20 a las 18 12 16_8ca3ead4](https://github.com/user-attachments/assets/a8c7a24a-a003-43c5-b2ed-af724c27189e)


---

## 🐳 Docker y Docker Compose

### ¿Cómo ejecutar el sistema completo?

```bash
# Generar los .jar
mvn clean package

# Levantar todo el sistema
docker-compose up --build
```

### Servicios disponibles localmente:

| Servicio         | URL                           |
|------------------|-------------------------------|
| Eureka           | http://localhost:8761         |
| Config Server    | http://localhost:8888         |
| Auth Service     | http://localhost:8080         |
| Usuarios         | http://localhost:8080/usuarios|
| Asignaturas      | http://localhost:8081         |
| Matrículas       | http://localhost:8082         |
| Prometheus       | http://localhost:9090         |
| Grafana          | http://localhost:3000         |

---

##  Postman Collection

Incluye una colección de Postman para probar:
- Registro e inicio de sesión
- Acceso con token a rutas protegidas
- Operaciones CRUD y matriculación
- Validación del flujo de seguridad

---

##  Autores

- Juan Esteban Rodríguez Murillo
- Juan Sebastián Rodríguez Avendaño

---

##  Conclusión

Este proyecto demuestra la aplicación de buenas prácticas DevOps con enfoque en:
- Microservicios bien definidos y desacoplados
- Seguridad y comunicación entre servicios
- Automatización de pruebas
- Observabilidad
- Despliegue reproducible con Docker
