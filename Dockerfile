# Build stage - compile the Spring Boot app
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy dependencies and download them first for layer caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build the jar
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage - lightweight image to run the app
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port for Render
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
