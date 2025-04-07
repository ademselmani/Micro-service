@echo off
cls
echo =====================================
echo  Hotel Room Management - Docker Stop 
echo =====================================

echo Stopping all services...

REM Stop all services
docker-compose down

REM Check the status
if %ERRORLEVEL% EQU 0 (
  echo All services have been stopped.
) else (
  echo Failed to stop services. Check the error messages above.
)

pause 