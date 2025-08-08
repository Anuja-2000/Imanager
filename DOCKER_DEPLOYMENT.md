# Docker Deployment Guide

## Prerequisites

- Docker installed on your system
- Docker Compose installed
- `.env` file configured with database credentials

## Quick Start

### Option 1: Using Build Script (Recommended)

**Windows:**
```cmd
build.bat
```

**Linux/Mac:**
```bash
chmod +x build.sh
./build.sh
```

### Option 2: Manual Build

1. **Build JAR file:**
   ```bash
   ./mvnw clean package -DskipTests
   ```

2. **Build Docker image:**
   ```bash
   docker build -t imanager-app .
   ```

3. **Run the container:**
   ```bash
   docker run -p 8080:8080 --env-file .env imanager-app
   ```

## Deployment Options

### 1. Production Deployment (Cloud Database)

Use your existing cloud database configuration:

```bash
docker-compose -f docker-compose.prod.yml up -d
```

### 2. Local Development (With Local MySQL)

Includes a local MySQL database:

```bash
docker-compose up -d
```

### 3. Single Container Run

```bash
docker run -d \
  --name imanager-app \
  -p 8080:8080 \
  --env-file .env \
  imanager-app
```

## Docker Commands Reference

### Build Commands
```bash
# Build image
docker build -t imanager-app .

# Build with multi-stage Dockerfile
docker build -f Dockerfile.multistage -t imanager-app-multistage .
```

### Run Commands
```bash
# Run with environment file
docker run -p 8080:8080 --env-file .env imanager-app

# Run with individual environment variables
docker run -p 8080:8080 \
  -e DB_URL="your_db_url" \
  -e DB_USERNAME="your_username" \
  -e DB_PASSWORD="your_password" \
  imanager-app

# Run in detached mode
docker run -d -p 8080:8080 --env-file .env imanager-app
```

### Management Commands
```bash
# View running containers
docker ps

# View logs
docker logs <container_id>

# Stop container
docker stop <container_id>

# Remove container
docker rm <container_id>

# Remove image
docker rmi imanager-app
```

## Docker Compose Commands

```bash
# Start services
docker-compose up -d

# Stop services
docker-compose down

# View logs
docker-compose logs

# Rebuild and restart
docker-compose up --build -d
```

## Environment Configuration

### For Production (.env file):
```properties
DB_URL=jdbc:mysql://your-cloud-host:port/Imanager_db?ssl-mode=REQUIRED
DB_USERNAME=your_username
DB_PASSWORD=your_password
```

### For Local Development:
The local MySQL container will automatically create the database. Update your `.env`:
```properties
DB_URL=jdbc:mysql://mysql-db:3306/Imanager_db
DB_USERNAME=imanager_user
DB_PASSWORD=imanager_pass
```

## Troubleshooting

### Common Issues

1. **Port already in use:**
   ```bash
   # Use different port
   docker run -p 8081:8080 --env-file .env imanager-app
   ```

2. **Database connection failed:**
   - Verify `.env` file exists and contains correct credentials
   - Check database server accessibility
   - Ensure database exists

3. **JAR file not found:**
   ```bash
   # Rebuild JAR file
   ./mvnw clean package -DskipTests
   ```

4. **Docker build fails:**
   ```bash
   # Clean Docker cache
   docker system prune -a
   ```

## Health Check

Once the container is running, check the application health:

```bash
curl http://localhost:8080/api/incomes
```

## Security Notes

1. Never include `.env` file in Docker images
2. Use Docker secrets for production deployments
3. Run containers as non-root user (implemented in Dockerfile)
4. Keep base images updated

## Performance Optimization

The Dockerfile includes:
- JVM memory optimization
- Non-root user execution
- Health checks
- Multi-stage builds (available in Dockerfile.multistage)

## Monitoring

Monitor your application:
```bash
# View container stats
docker stats

# View container processes
docker top <container_id>
```
