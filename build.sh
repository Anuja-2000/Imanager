#!/bin/bash
set -e

echo "Building Imanager Application..."

echo ""
echo "Step 1: Building JAR file..."
./mvnw clean package -DskipTests

echo ""
echo "Step 2: Building Docker image..."
docker build -t imanager-app .

echo ""
echo "✅ Build completed successfully!"
echo ""
echo "Available commands:"
echo "  docker run -p 8080:8080 --env-file .env imanager-app"
echo "  docker-compose -f docker-compose.prod.yml up"
echo "  docker-compose up (for local development with MySQL)"
echo ""
