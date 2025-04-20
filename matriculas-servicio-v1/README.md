#  Microservicio: Matrículas

Este microservicio gestiona las inscripciones de estudiantes en materias, junto con el profesor asignado.

---

## Inicialización del Microservicio

Para compilar y ejecutar este microservicio de forma local, se usa uno de los siguientes comandos:

```bash
mvn clean package
java -jar target/*.jar
```

O usando el wrapper de Maven:

```bash
./mvnw spring-boot:run
```

## Colección Postman

Este microservicio cuenta con una colección de Postman incluida en el proyecto para facilitar las pruebas de los endpoints.

## Ejecución de Tests

Este proyecto incluye pruebas automáticas (unitarias y/o de integración).  
Las ejecutaremos con:

```bash
./mvnw test
```


##  Funcionalidades

- Registrar una matrícula (asignar estudiante + profesor + materia)
- Consultar todas las matrículas con detalles
- Eliminar una matrícula

---

##  Comunicación entre microservicios

Consume datos de:
- `auth-service`: validación de token
- `usuarios-servicio`: obtener estudiante y profesor
- `asignaturas-servicio`: obtener materia

Usa `FeignClient` para realizar llamadas entre servicios.

---

##  Endpoints

| Método | Ruta               | Función                      |
|--------|--------------------|------------------------------|
| POST   | /matriculas        | Registra una matrícula       |
| GET    | /matriculas        | Lista todas las matrículas   |
| DELETE | /matriculas/{id}   | Elimina una matrícula        |

 Todos requieren el header:

```http
Authorization: Bearer <token_jwt>
```

---

##  Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Feign
- Maven

---

##  Estructura

```
matriculas/
├── controller/
├── model/
├── repository/
├── service/
├── client/
└── resources/
```

---

##  Autores

- Juan Esteban Rodríguez Murillo
- Juan Sebastián Rodríguez Avendaño

Proyecto académico para demostrar conocimientos en integración de microservicios y seguridad distribuida.
