package edu.learning.microservices.core.review.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MySqlConfig implements ApplicationRunner {

    private static final Logger LOG = LogManager.getLogger(MySqlConfig.class);

    @Value("${spring.datasource.url}")
    private String mysqlUri;

    @Override
    public void run(ApplicationArguments args) {
        LOG.info("Connected to MySQL: " + mysqlUri);
    }
}
