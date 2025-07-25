package edu.learning.microservices.core.product.persistence.helper;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

public abstract class MongoDbTestBase {

    @ServiceConnection
    private static MongoDBContainer database = new MongoDBContainer("mongo:6.0.4");

    static {
        database.start();
    }

}
