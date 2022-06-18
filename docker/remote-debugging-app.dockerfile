FROM openjdk:11-jdk-slim

COPY target/learn-0.0.1.jar app.jar

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000", "-jar", "/app.jar"]