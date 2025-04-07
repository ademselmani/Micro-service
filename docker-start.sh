#!/bin/bash

# Print colorful header
echo -e "\e[1;34m======================================\e[0m"
echo -e "\e[1;34m Hotel Room Management - Docker Start \e[0m"
echo -e "\e[1;34m======================================\e[0m"

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
  echo -e "\e[1;31mError: Docker is not running or not installed.\e[0m"
  echo "Please start Docker and try again."
  exit 1
fi

echo -e "\e[1;33mBuilding and starting all services...\e[0m"

# Build and start all services in detached mode
docker-compose up --build -d

# Check the status
if [ $? -eq 0 ]; then
  echo -e "\e[1;32mAll services are now running!\e[0m"
  
  echo -e "\n\e[1;36mService URLs:\e[0m"
  echo -e "- Frontend: \e[1;36mhttp://localhost:3000\e[0m"
  echo -e "- Eureka Dashboard: \e[1;36mhttp://localhost:8761\e[0m"
  echo -e "- API Gateway: \e[1;36mhttp://localhost:8078\e[0m"
  echo -e "- Chombre Service: \e[1;36mhttp://localhost:8090\e[0m"
  
  echo -e "\n\e[1;33mTo view logs in real-time, run:\e[0m"
  echo -e "docker-compose logs -f"
  
  echo -e "\n\e[1;33mTo stop all services, run:\e[0m"
  echo -e "bash docker-stop.sh"
else
  echo -e "\e[1;31mFailed to start services. Check the error messages above.\e[0m"
fi 