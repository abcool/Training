package edu.learning.microservices.core.review;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@TestConfiguration(proxyBeanMethods = false)
public class TestApplicationConfiguration {

    @Bean
    @ServiceConnection
    MySQLContainer<?> mysqlContainer2() {
        return new MySQLContainer<>("mysql:8.4")
                .withStartupTimeout(Duration.of(300, ChronoUnit.SECONDS))
                .withInitScript("schema.sql")  // Testcontainers will execute via JDBC
                .withReuse(false);
    }
}
