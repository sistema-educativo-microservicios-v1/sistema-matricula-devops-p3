# Imagen base de Java 17
FROM openjdk:17-jdk-slim
# Copia el jar al contenedor
COPY target/matriculas-0.0.1-SNAPSHOT.jar app.jar
# Expone el puerto del microservicio
EXPOSE 8082
# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
