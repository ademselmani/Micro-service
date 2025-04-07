@echo off
setlocal enabledelayedexpansion

:: Colors for Windows terminal
set GREEN=[92m
set YELLOW=[93m
set RED=[91m
set NC=[0m

echo %YELLOW%=====================================================
echo   Microservices Docker Management Script
echo =====================================================
echo %NC%

if "%1"=="" goto help
if "%1"=="help" goto help
if "%1"=="start" goto start
if "%1"=="stop" goto stop
if "%1"=="restart" goto restart
if "%1"=="status" goto status
if "%1"=="logs" goto logs
if "%1"=="build" goto build
if "%1"=="clean" goto clean
goto help

:help
echo %GREEN%Usage:%NC%
echo docker-run.bat [command]
echo.
echo %GREEN%Available commands:%NC%
echo   start      - Start all services
echo   stop       - Stop all services
echo   restart    - Restart all services
echo   status     - Show status of containers
echo   logs       - Show logs from all services
echo   build      - Rebuild all images
echo   clean      - Remove all containers and volumes
echo   help       - Show this help message
echo.
goto end

:start
echo %GREEN%Starting all services...%NC%
docker-compose up -d
echo.
echo %GREEN%Services started. Access URLs:%NC%
echo Discovery Service: http://localhost:8761
echo Gateway: http://localhost:8078
echo Chombre Service: http://localhost:8089
echo Chombre Swagger UI: http://localhost:8089/swagger-ui.html
echo H2 Console: http://localhost:8089/h2-console
goto end

:stop
echo %GREEN%Stopping all services...%NC%
docker-compose down
goto end

:restart
echo %GREEN%Restarting all services...%NC%
docker-compose down
docker-compose up -d
goto end

:status
echo %GREEN%Services status:%NC%
docker-compose ps
goto end

:logs
echo %GREEN%Services logs:%NC%
docker-compose logs -f
goto end

:build
echo %GREEN%Building all services...%NC%
docker-compose build --no-cache
goto end

:clean
echo %RED%WARNING: This will remove all containers and volumes.%NC%
set /p CONFIRM=Are you sure you want to continue? (y/n): 
if /i "%CONFIRM%"=="y" (
    docker-compose down -v
    echo %GREEN%All containers and volumes removed.%NC%
)
goto end

:end
endlocal 