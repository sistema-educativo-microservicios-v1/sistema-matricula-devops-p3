# Imagen base de Java 17
FROM openjdk:17-jdk-slim
# Copia el jar al contenedor
COPY target/eureka-server-0.0.1-SNAPSHOT.jar app.jar
# Expone el puerto del microservicio
EXPOSE 8761
# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
