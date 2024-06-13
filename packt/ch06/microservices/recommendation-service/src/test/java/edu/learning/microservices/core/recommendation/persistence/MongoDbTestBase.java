package edu.learning.microservices.core.recommendation.persistence;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;

public abstract class MongoDbTestBase {
   private static MongoDBContainer mongoDB = new MongoDBContainer("mongo:5.0.27");

    static {
        mongoDB.start();
    }
    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.host", mongoDB::getContainerIpAddress);
        registry.add("spring.data.mongodb.port", () -> mongoDB.getMappedPort(27017));
        registry.add("spring.data.mongodb.database", () -> "test");
    }
}
