#  Config Server - Sistema Educativo

Este microservicio actúa como servidor centralizado de configuración para los demás microservicios del sistema educativo. Permite gestionar las configuraciones desde un repositorio remoto en GitHub, facilitando la administración y manteniendo la coherencia entre entornos.

##  Tecnologías

- Java 17
- Spring Boot 3.x
- Spring Cloud Config Server
- Maven

##  ¿Qué hace?

- Expone un servidor de configuración centralizado.
- Obtiene los archivos de configuración desde un repositorio remoto de GitHub.
- Permite a los demás microservicios leer su configuración desde aquí al momento de arrancar.

##  Visión general del sistema

Este proyecto hace parte de un sistema basado en microservicios para gestionar una institución educativa. Cada microservicio tiene una función específica (usuarios, cursos, materias, etc.), y todos comparten configuración a través de este Config Server. De esta forma, centralizamos propiedades como puertos, nombres de servicios, credenciales, y más.

##  Configuración

En `application.properties` se define la URL del repositorio remoto donde están las configuraciones:

```properties
server.port=8888
spring.application.name=config-server
spring.cloud.config.server.git.uri=https://github.com/sistema-educativo-microservicios-v1/config-server1.git
spring.cloud.config.server.git.clone-on-start=true
```

---

##  Estructura del proyecto

```config-server/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/sistema/config/
│       │       └── ConfigServerApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

##  Ejecución

Para ejecutar el servidor de configuración:
mvn spring-boot:run


##  Autores

- Juan Esteban Rodríguez Murillo
- Juan Sebastián Rodríguez Avendaño

Desarrollado como parte de un parcial para la materia de lenguaje de programación avanzado 2.