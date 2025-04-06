# Architecture Diagram

This directory contains the architecture diagram for the microservices project.

The text-based diagram in `architecture-diagram.txt` can be converted to an image for the README.

## How to View

For now, if the image in the README doesn't load, you can see the text-based version here:

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│                 │     │                 │     │                 │
│     Client      │────▶│  API Gateway    │────▶│ Chombre Service │
│                 │     │   (port 8078)   │     │   (port 8089)   │
└─────────────────┘     └─────────────────┘     └─────────────────┘
                               │
                               │
                               ▼
                        ┌─────────────────┐
                        │                 │
                        │ Discovery Server│
                        │   (port 8761)   │
                        │                 │
                        └─────────────────┘
```

## Components

- **Client**: End users or applications accessing the services
- **API Gateway (port 8078)**: Routes client requests to appropriate services
- **Discovery Server (port 8761)**: Eureka server for service registration and discovery
- **Chombre Service (port 8089)**: Main service for room management and ratings 