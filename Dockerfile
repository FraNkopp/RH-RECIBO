FROM amazoncorretto:8-alpine

EXPOSE 8080

COPY target/web-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]