FROM  maven:3.9.6 AS build

WORKDIR /app

COPY ./pom.xml ./pom.xml

COPY ./src ./src

RUN mvn clean package  -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/AFTAS-0.0.1-SNAPSHOT.jar ./

EXPOSE 8080

# CMD ["java", "-jar", "app.jar"]

CMD ["java", "-jar", "AFTAS-0.0.1-SNAPSHOT.jar"]