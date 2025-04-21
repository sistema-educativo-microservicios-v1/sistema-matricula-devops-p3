# Imagen base de Java 17
FROM openjdk:17-jdk-slim
# Copia el jar al contenedor
COPY target/asignaturas-servicio-0.0.1-SNAPSHOT.jar app.jar
# Expone el puerto del microservicio
EXPOSE 8081
# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
