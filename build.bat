@echo off
echo Building Imanager Application...

echo.
echo Step 1: Building JAR file...
call mvnw.cmd clean package -DskipTests

if %ERRORLEVEL% neq 0 (
    echo ERROR: Failed to build JAR file
    exit /b 1
)

echo.
echo Step 2: Building Docker image...
docker build -t imanager-app .

if %ERRORLEVEL% neq 0 (
    echo ERROR: Failed to build Docker image
    exit /b 1
)

echo.
echo ✅ Build completed successfully!
echo.
echo Available commands:
echo   docker run -p 8080:8080 --env-file .env imanager-app
echo   docker-compose -f docker-compose.prod.yml up
echo   docker-compose up (for local development with MySQL)
echo.
