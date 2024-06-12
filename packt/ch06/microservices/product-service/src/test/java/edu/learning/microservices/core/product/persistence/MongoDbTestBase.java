package edu.learning.microservices.core.product.persistence;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.ArrayList;
import java.util.List;

public abstract class MongoDbTestBase {
    private static final int MONGO_PORT = 27017;
   // private static GenericContainer mongoDB = new GenericContainer(DockerImageName.parse("mongo:5.0.27"));
   private static MongoDBContainer mongoDB = new MongoDBContainer("mongo:5.0.27");

    static {
//        List<String> list = new ArrayList<>();
//        list.add("MONGO_INITDB_ROOT_USERNAME=admin");
//        list.add("MONGO_INITDB_ROOT_PASSWORD=admin");
//        list.add("MONGO_INITDB_DATABASE=test");
//        mongoDB.setEnv(list);
//        mongoDB.withExposedPorts(MONGO_PORT);
        mongoDB.start();
    }
    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.host", mongoDB::getContainerIpAddress);
        registry.add("spring.data.mongodb.port", () -> mongoDB.getMappedPort(27017));
        registry.add("spring.data.mongodb.database", () -> "test");
    }
}
