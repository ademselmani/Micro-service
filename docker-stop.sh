#!/bin/bash

# Print colorful header
echo -e "\e[1;34m=====================================\e[0m"
echo -e "\e[1;34m Hotel Room Management - Docker Stop \e[0m"
echo -e "\e[1;34m=====================================\e[0m"

echo -e "\e[1;33mStopping all services...\e[0m"

# Stop all services
docker-compose down

# Check the status
if [ $? -eq 0 ]; then
  echo -e "\e[1;32mAll services have been stopped.\e[0m"
else
  echo -e "\e[1;31mFailed to stop services. Check the error messages above.\e[0m"
fi 