# Microservice Architecture Project



## Project Structure

The project is built using a microservice architecture with the following components:

### 1. Eureka Service Discovery (eurekaMs)
- A service registry that allows microservices to find and communicate with each other.
- Port: 8761
- Used for service discovery and registration.

### 2. API Gateway (ApiJob)
- Acts as an entry point for all client requests.
- Port: 8093
- Routes traffic to appropriate microservices.
- Registers with Eureka for service discovery.

### 3. Bloc Service (MsFoyer)
- Business logic microservice.
- Port: 8089
- Connects to MySQL database.
- Registers with Eureka for service discovery.

### 4. MySQL Database
- Database for storing application data.
- Port: 3306
- Database name: msDB

## Technologies Used

- **Spring Boot**: Framework for creating microservices
- **Spring Cloud Netflix Eureka**: Service discovery
- **Spring Cloud Gateway**: API Gateway implementation
- **Docker**: Containerization platform
- **MySQL**: Database
- **Angular**: Frontend framework (running on port 4200)

## How to Run the Project

### Cloning the Repository

```bash
git clone -b zeinebmaatallii https://github.com/ademselmani/Micro-service.git
cd Micro-service
```

### Running with Docker Compose

1. Make sure Docker is installed on your system
2. Run the following command to start all services:

```bash
docker-compose up -d
```

This will start:
- Eureka Service on port 8761
- API Gateway on port 8093
- Bloc Service on port 8089
- MySQL on port 3306

### Accessing Services

- **Eureka Dashboard**: http://localhost:8761
- **API Gateway**: http://localhost:8093
- **Frontend Application**: http://localhost:4200

## Component Details

### Eureka Service
Eureka provides service discovery allowing microservices to find and communicate with each other without hardcoding host and port. It serves as a registry where all microservices register themselves.

### API Gateway
The API Gateway is the entry point for all client requests. It routes requests to the appropriate microservice based on the path. It also provides cross-cutting concerns like security, monitoring, and resilience.

Routes configured:

- `/microService/**` → Service "MsFoyer" (load balanced)

### Bloc Service
The Bloc Service (MsFoyer) contains the business logic of the application and connects to the MySQL database. It registers with Eureka to be discoverable by other services.

### Frontend Application
The Angular frontend application runs on port 4200 and communicates with the backend services through the API Gateway.

## Docker Compose Configuration
The docker-compose.yml file defines and configures all the services:
- Sets up networking between containers
- Maps ports to host machine
- Defines environment variables for service configuration
- Manages dependencies between services

## Author
- Zeineb Maatalli
