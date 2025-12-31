package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.product.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(url = "${product-service-url}", name = "product-service-client")
public interface ProductServiceClient {

    @GetMapping(path = "/product/{productId}")
    Mono<ResponseEntity<ProductDTO>> getProduct(@PathVariable(name = "productId") int productId);

}