FROM openjdk:17-jdk-slim-buster
LABEL authors="danilskryl"
ENV PORT 8082
EXPOSE 8082
WORKDIR /app
COPY build/libs/kafka-producer-0.0.1-SNAPSHOT.jar /app/app.jar
COPY src/main/resources/application.properties /app/application.properties

ENTRYPOINT ["java", "-jar", "app.jar"]