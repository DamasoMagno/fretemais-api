# Stage 1: Build stage
FROM openjdk:21.0.5-jdk AS build
WORKDIR /app

# Copy Maven configuration and source files
COPY pom.xml .
COPY src src
COPY mvnw .
COPY .mvn .mvn

# Set execution permission for Maven wrapper and build the application
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Final Docker image
FROM openjdk:21.0.5-jdk-slim
WORKDIR /app

# Expose a volume for temporary files (optional, good practice)
VOLUME /tmp

# Copy the generated JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Configure entry point with dynamic port from Render's environment
ENTRYPOINT ["java", "-jar", "/app.jar", "--server.port=${PORT}"]

# Default exposed port for local testing
EXPOSE 8080
