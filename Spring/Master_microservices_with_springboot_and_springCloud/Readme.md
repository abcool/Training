# Running Microservices with Spring Boot and Spring Cloud

This document provides instructions on how to run the individual microservices, the complete application, and how to set up debugging.

## Running Services Standalone

### Running `product-service` standalone

1.  Navigate to the `product-service` directory:
    ```bash
    cd microservices/product-service
    ```

2.  Clean and build the service:
    ```bash
    ../../gradlew :microservices:product-service:clean
    ../../gradlew :microservices:product-service:build
    ```

3.  Build the Docker image:
    ```bash
    docker build -t product-service .
    ```

4.  Run a MongoDB container:
    ```bash
    docker run -d --name mongodb --hostname mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password -e MONGO_INITDB_DATABASE=product-db mongo:6.0.2
    ```

5.  (Optional) Access the MongoDB shell:
    ```bash
    docker exec -it mongodb mongosh -u admin -p password --authenticationDatabase admin product-db
    ```
    Inside the shell, you can inspect the collections:
    ```javascript
    show collections
    db.getCollection('products').find()
    ```

6.  Create a Docker network:
    ```bash
    docker network create product-net
    ```

7.  Connect MongoDB to the network:
    ```bash
    docker network connect product-net mongodb
    ```

8.  Run the `product-service` container:
    ```bash
    docker run --rm --network product-net -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" -e "SPRING_DATA_MONGODB_URI=mongodb://admin:password@mongodb:27017/product-db?authSource=admin" product-service
    ```

### Running `recommendation-service` standalone

1.  Navigate to the `recommendation-service` directory:
    ```bash
    cd microservices/recommendation-service
    ```

2.  Clean and build the service:
    ```bash
    ../../gradlew :microservices:recommendation-service:clean
    ../../gradlew :microservices:recommendation-service:build
    ```

3.  Build the Docker image:
    ```bash
    docker build -t recommendation-service .
    ```

4.  Run a MongoDB container (if not already running):
    ```bash
    docker run -d --name mongodb --hostname mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password -e MONGO_INITDB_DATABASE=recommendation-db mongo:6.0.2
    ```

5.  Create a Docker network:
    ```bash
    docker network create recommendation-net
    ```

6.  Connect MongoDB to the network:
    ```bash
    docker network connect recommendation-net mongodb
    ```

7.  Run the `recommendation-service` container:
    ```bash
    docker run --rm --network recommendation-net -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" -e "SPRING_DATA_MONGODB_URI=mongodb://admin:password@mongodb:27017/recommendation-db?authSource=admin" recommendation-service
    ```

### Running `review-service` standalone

1.  Navigate to the `review-service` directory:
    ```bash
    cd microservices/review-service
    ```

2.  Clean and build the service:
    ```bash
    ../../gradlew :microservices:review-service:clean
    ../../gradlew :microservices:review-service:build
    ```

3.  Build the Docker image:
    ```bash
    docker build -t review-service .
    ```

4.  Create a Docker network:
    ```bash
    docker network create review-net
    ```

5.  Run a MySQL container:
    ```bash
    docker run -d --name mysql --network review-net -p 3306:3306 -e MYSQL_DATABASE=review-db -e MYSQL_USER=user -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=root mysql:8.4
    ```

6.  (Optional) Access the MySQL shell:
    ```bash
    docker exec -it mysql mysql -u user -ppassword review-db
    ```

7.  Run the `review-service` container:
    ```bash
    docker run --rm --network review-net -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" -e "SPRING_R2DBC_URL=r2dbc:mysql://mysql:3306/review-db" -e "SPRING_R2DBC_USERNAME=user" -e "SPRING_R2DBC_PASSWORD=password" review-service
    ```

## Running the Complete Application with Docker Compose

1.  Clean and build all services:
    ```bash
    ./gradlew clean build
    ```

2.  Build the Docker images using Docker Compose. To remove existing images and rebuild, use:
    ```bash
    docker compose down --rmi local
    docker compose build
    ```
    Or in a single command:
    ```bash
    docker compose down --rmi local && docker compose build --no-cache
    ```

3.  Start all services in detached mode:
    ```bash
    docker compose up -d
    ```

4.  View logs for specific services:
    ```bash
    docker compose logs product-service -f
    docker compose logs recommendation-service -f
    docker compose logs review-service -f
    ```

## Setting up Remote Debugging in IntelliJ

1.  Go to `Run -> Edit Configurations...`.
2.  Click the **+** (Plus) icon and select **Remote JVM Debug**.
3.  Set **Name** to "Docker Debug".
4.  Set **Host** to `localhost`.
5.  Set **Port** to `5005`.
6.  Click **Apply** and then **Debug**.
