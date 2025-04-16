# Build stage
FROM --platform=linux/amd64 maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Runtime stage
FROM --platform=linux/amd64 openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application's port
EXPOSE 8090

# Create directory for uploads
RUN mkdir -p /app/uploads/images

# Install curl and other utilities for testing
RUN apt-get update && \
    apt-get install -y curl wget jq nano && \
    rm -rf /var/lib/apt/lists/*

# Create a test script for CORS
RUN echo '#!/bin/bash\n\
echo "Testing CORS Configuration"\n\
echo "OPTIONS request:"\n\
curl -v -H "Origin: http://localhost:3000" -H "Access-Control-Request-Method: GET" -X OPTIONS http://localhost:8090/api/rooms\n\
echo "\n\nGET request:"\n\
curl -v -H "Origin: http://localhost:3000" http://localhost:8090/api/rooms\n\
' > /app/test-cors.sh && chmod +x /app/test-cors.sh

# Run the application with spring.profiles.active=docker
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]
