FROM openjdk:8
ADD target/mainRequest-service.jar mainRequest-service.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "mainRequest-service.jar"]