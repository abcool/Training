package edu.learning.microservices.composite.product;

import edu.learning.microservices.composite.product.config.APIDocsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("edu.learning")
public class ProductCompositeServiceApplication {

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	APIDocsConfig docsConfig;

	public static void main(String[] args) {
		SpringApplication.run(ProductCompositeServiceApplication.class, args);
	}

}
