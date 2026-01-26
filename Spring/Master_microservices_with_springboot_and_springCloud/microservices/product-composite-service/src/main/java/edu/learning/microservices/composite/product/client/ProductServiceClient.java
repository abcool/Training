package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.product.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(url = "${product-service-url}", name = "product-service")
public interface ProductServiceClient {

    @GetMapping(path = "/product/{productId}")
    Mono<ProductDTO> getProduct(@PathVariable Integer productId);

    @PostMapping(value = "/product", consumes = "application/json", produces = "application/json")
    Mono<ProductDTO> createProduct(@RequestBody ProductDTO body);

    @DeleteMapping(value = "/product/{productId}")
    Mono<Void> deleteProduct(@PathVariable Integer productId); // Changed to Mono

}