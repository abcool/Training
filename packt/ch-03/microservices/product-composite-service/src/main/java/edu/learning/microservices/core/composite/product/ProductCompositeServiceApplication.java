package edu.learning.microservices.core.composite.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("edu.learning")
public class ProductCompositeServiceApplication {
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductCompositeServiceApplication.class, args);
	}

}
