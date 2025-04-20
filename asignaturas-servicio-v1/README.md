#  Microservicio: Asignaturas

Este microservicio gestiona las materias del sistema educativo. Permite crear, consultar, actualizar y eliminar asignaturas. Además, valida el acceso mediante tokens JWT.

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


##  Funciones principales

- Crear una asignatura
- Obtener una asignatura por ID
- Listar todas las asignaturas
- Actualizar una asignatura
- Eliminar una asignatura

---

##  Seguridad

Valida tokens JWT mediante un `FeignClient` que se conecta al microservicio de autenticación (`auth-service`).  
Todos los endpoints requieren el header:

```http
Authorization: Bearer <token_jwt>
```

---

##  Tecnologías

- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- PostgreSQL
- Feign Client
- Lombok
- Maven

---

##  Endpoints

| Método | Ruta | Función |
|--------|------|---------|
| GET    | /asignaturas       | Lista todas las asignaturas |
| GET    | /asignaturas/{id}  | Consulta una asignatura     |
| POST   | /asignaturas       | Crea una asignatura         |
| PUT    | /asignaturas/{id}  | Actualiza una asignatura    |
| DELETE | /asignaturas/{id}  | Elimina una asignatura      |

---

##  Estructura

```
asignaturas/
├── controller/
├── model/
├── repository/
├── service/
├── security/
└── resources/
```

---

##  Autores

- Juan Esteban Rodríguez Murillo
- Juan Sebastián Rodríguez Avendaño

Trabajo realizado para proyecto académico de microservicios con Spring Boot.
