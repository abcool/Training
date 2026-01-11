package edu.learning.microservices.core.product.config;

import edu.learning.microservices.core.product.persistence.ProductEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

@Component
public class MongoConfig {

    private static final Logger LOG = LogManager.getLogger(MongoConfig.class);

    @Autowired
    private ReactiveMongoOperations mongoTemplate;  // Changed to ReactiveMongoOperations

    @Autowired
    private Environment env;

    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        LOG.info("Creating MongoDB indexes...");

        mongoTemplate.indexOps(ProductEntity.class)
                .ensureIndex(new Index().on("productId", Sort.Direction.ASC).unique())
                .subscribe(
                        index -> LOG.info("Index created: {}", index),
                        error -> LOG.error("Failed to create index", error)
                );

        String mongoDbHost = env.getProperty("spring.data.mongodb.host");
        String mongoDbPort = env.getProperty("spring.data.mongodb.port");
        LOG.info("Connected to MongoDb: {}:{}", mongoDbHost, mongoDbPort);
    }
}