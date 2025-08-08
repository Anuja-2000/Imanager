FROM eclipse-temurin:24-jre-alpine
VOLUME /tmp
COPY target/Imanager-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]