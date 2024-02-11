FROM openjdk:17-jdk-slim-buster
LABEL authors="danilskryl"
ENV PORT 8083
EXPOSE 8083
WORKDIR /app
COPY build/libs/kafka-consumer-0.0.1-SNAPSHOT.jar /app/app.jar
COPY src/main/resources/application.properties /app/application.properties

ENTRYPOINT ["java", "-jar", "app.jar"]