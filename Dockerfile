FROM openjdk:17.0.1

EXPOSE 8080

ADD target/technozone-bff.jar technozone-bff.jar

CMD ["java", "-jar", "/technozone-bff.jar"]