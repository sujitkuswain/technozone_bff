FROM openjdk:17.0.1

COPY target/technozone-bff-0.0.1-SNAPSHOT.jar /app/technozone-bff.jar

CMD ["java", "-jar", "/app/technozone-bff.jar"]