FROM openjdk:8-jdk-alpine

LABEL maintainer="Tu Nombre <tu@email.com>"
LABEL description="Descripción de tu aplicación"

EXPOSE 8080

COPY target/recibo2-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
