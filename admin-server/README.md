#  Admin Server - Spring Boot Admin

Este microservicio es una consola de monitoreo construida con **Spring Boot Admin**.  
Permite visualizar el estado de los demás microservicios del sistema educativo desde una interfaz web, incluyendo su disponibilidad, uso de recursos, endpoints, y más.

---

##  ¿Qué hace?

- Muestra un dashboard con el estado (`UP/DOWN`) de cada microservicio.
- Permite ver métricas, información de sistema, logs, beans, etc.
- Facilita la administración y monitoreo sin usar Postman o consola.

---

##  Configuración

###  Dependencias usadas (`pom.xml`):

```xml
<dependency>
  <groupId>de.codecentric</groupId>
  <artifactId>spring-boot-admin-starter-server</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

###  application.properties:

```properties
server.port=9090
spring.application.name=admin-server
spring.boot.admin.discovery.enabled=true
spring.cloud.discovery.enabled=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

---

##  Integración con Eureka

Este servicio se registra en Eureka (`localhost:8761`) y descubre los demás microservicios automáticamente, siempre que ellos:

- También estén registrados en Eureka
- Tengan el endpoint `/actuator` habilitado
- Usen el starter `spring-boot-admin-starter-client`

---

## ▶️ Ejecución

```bash
mvn spring-boot:run
```

Luego accedemos a:

[http://localhost:9090](http://localhost:9090)

---

##  Verificación

En la interfaz veremos una tarjeta por cada microservicio registrado.  
Al hacer clic, podemos ver:
- Estado de salud (`/health`)
- Endpoints expuestos
- Información del sistema
- Registro en Eureka
- Logs 

---

 *Este microservicio corresponde al punto 6 del parcial , como consola de monitoreo visual.*
