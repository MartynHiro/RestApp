FROM openjdk:8-jdk-alpine

EXPOSE 8080

COPY target/ConditionalApp-1.0-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]