FROM openjdk:17-jdk-alpine
COPY target/technozone-bff-0.0.1-SNAPSHOT.jar /app/technozone-bff.jar
CMD ["java", "-jar", "/app/technozone-bff.jar"]