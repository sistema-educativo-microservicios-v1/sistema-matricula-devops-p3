#  Microservicio: Eureka Server

Este microservicio actúa como un **servidor de descubrimiento de servicios** en una arquitectura de microservicios.  
Permite que los demás servicios (como usuarios, asignaturas y matrículas) se registren automáticamente y se comuniquen entre sí sin usar direcciones IP fijas.

---

##  Funcionalidad principal

- Centraliza el registro y descubrimiento de microservicios
- Permite que los microservicios se comuniquen usando sus nombres (`spring.application.name`)
- Interfaz web para ver los servicios activos

---

##  Cómo usar

1. Clonar o importar el proyecto `eureka-server`
2. Ejecutar la clase `EurekaServerApplication`
3. Acceder a la consola en: [http://localhost:8761](http://localhost:8761)

---

##  Configuración usada (`application.properties`)

```properties
server.port=8761
spring.application.name=eureka-server
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

---

##  Dependencias principales (`pom.xml`)

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>

<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>2022.0.3</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

---

##  Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Cloud Netflix Eureka
- Maven

---

##  Autores

- Juan Esteban Rodríguez Murillo
- Juan Sebastián Rodríguez Avendaño

Proyecto académico para implementar descubrimiento de servicios en una arquitectura de microservicios con Spring Cloud.
