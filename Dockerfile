FROM openjdk:17.0.1

EXPOSE 8080

WORKDIR /app

COPY target/technozone-bff.jar technozone-bff.jar

CMD ["java", "-jar", "technozone-bff.jar"]