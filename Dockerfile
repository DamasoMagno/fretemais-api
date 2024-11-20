# Estágio de Build
FROM openjdk:21-jdk AS build
WORKDIR /app

COPY pom.xml .
COPY src src

COPY mvnw .
COPY .mvn .mvn
RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests

# Estágio Final
FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
