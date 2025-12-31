package edu.learning.microservices.composite.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@ComponentScan("edu.learning")
@EnableReactiveFeignClients
public class ProductCompositeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCompositeServiceApplication.class, args);
	}

}
