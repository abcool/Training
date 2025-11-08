#!/bin/bash

set -e

# Configurable variables
APP_NAME=review-service
APP_PORT=8080
MYSQL_CONTAINER=mysql-db
MYSQL_PORT=3306
MYSQL_ROOT_PASSWORD=rootpassword
MYSQL_DATABASE=review
IMAGE_NAME=review-service
JAR_PATH=build/libs/*.jar

# 1. Start MySQL container if not already running
if [ "$(docker ps -q -f name=$MYSQL_CONTAINER)" ]; then
  echo "MySQL container '$MYSQL_CONTAINER' is already running."
else
  if [ "$(docker ps -aq -f status=exited -f name=$MYSQL_CONTAINER)" ]; then
    echo "Starting existing MySQL container..."
    docker start $MYSQL_CONTAINER
  else
    echo "Creating and starting new MySQL container..."
    docker run -d \
      --name $MYSQL_CONTAINER \
      -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD \
      -e MYSQL_DATABASE=$MYSQL_DATABASE \
      -p $MYSQL_PORT:3306 \
      -v mysql-data:/var/lib/mysql \
      mysql:8.0 \
      --default-authentication-plugin=mysql_native_password
  fi
fi

# 2. Build Docker image for Spring Boot app
echo "Building Docker image for $APP_NAME..."
docker build -t $IMAGE_NAME .

# 3. Stop and remove existing app container if it exists
if [ "$(docker ps -aq -f name=$APP_NAME)" ]; then
  echo "Removing existing $APP_NAME container..."
  docker stop $APP_NAME >/dev/null 2>&1 || true
  docker rm $APP_NAME >/dev/null 2>&1 || true
fi

# 4. Run Spring Boot container
echo "Starting $APP_NAME container..."
docker run -d \
  --name $APP_NAME \
  --link $MYSQL_CONTAINER:mysql \
  -p $APP_PORT:$APP_PORT \
  -e SPRING_PROFILES_ACTIVE=docker \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/$MYSQL_DATABASE \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD=$MYSQL_ROOT_PASSWORD \
  $IMAGE_NAME

echo "✅ $APP_NAME is running on http://localhost:$APP_PORT"
echo "🛠 Swagger UI: http://localhost:$APP_PORT/openapi/swagger-ui.html"
echo
echo "📋 Streaming logs for $APP_NAME:"
echo "------------------------------------"
docker logs -f $APP_NAME
