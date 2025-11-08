#!/bin/bash

set -e

# Configurable variables
APP_NAME=recommendation-service
APP_PORT=8080
MONGO_CONTAINER=mongodb
MONGO_PORT=27017
IMAGE_NAME=recommendation-service
JAR_PATH=build/libs/*.jar

# 1. Start MongoDB container if not already running
if [ "$(docker ps -q -f name=$MONGO_CONTAINER)" ]; then
  echo "MongoDB container '$MONGO_CONTAINER' is already running."
else
  if [ "$(docker ps -aq -f status=exited -f name=$MONGO_CONTAINER)" ]; then
    echo "Starting existing MongoDB container..."
    docker start $MONGO_CONTAINER
  else
    echo "Creating and starting new MongoDB container..."
    docker run -d \
      --name $MONGO_CONTAINER \
      -p $MONGO_PORT:27017 \
      -v mongo-data:/data/db \
      mongo:6.0
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
  --link $MONGO_CONTAINER:mongodb \
  -p $APP_PORT:$APP_PORT \
  -e SPRING_PROFILES_ACTIVE=docker \
  $IMAGE_NAME

echo "✅ $APP_NAME is running on http://localhost:$APP_PORT"
echo "🛠 Swagger UI: http://localhost:$APP_PORT/openapi/swagger-ui.html"
echo
echo "📋 Streaming logs for $APP_NAME:"
echo "------------------------------------"
docker logs -f $APP_NAME