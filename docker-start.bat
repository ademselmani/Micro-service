@echo off
cls
echo ======================================
echo  Hotel Room Management - Docker Start 
echo ======================================

REM Check if Docker is running
docker info > nul 2>&1
if %ERRORLEVEL% NEQ 0 (
  echo Error: Docker is not running or not installed.
  echo Please start Docker and try again.
  exit /b 1
)

echo Building and starting all services...

REM Build and start all services in detached mode
docker-compose up --build -d

REM Check the status
if %ERRORLEVEL% EQU 0 (
  echo All services are now running!
  
  echo.
  echo Service URLs:
  echo - Frontend: http://localhost:3000
  echo - Eureka Dashboard: http://localhost:8761
  echo - API Gateway: http://localhost:8078
  echo - Chombre Service: http://localhost:8090
  
  echo.
  echo To view logs in real-time, run:
  echo docker-compose logs -f
  
  echo.
  echo To stop all services, run:
  echo docker-stop.bat
) else (
  echo Failed to start services. Check the error messages above.
)

pause 