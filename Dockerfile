FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/technozone-bff.jar technozone-bff.jar
EXPOSE 8080
CMD ["java", "-jar", "technozone-bff.jar"]