package edu.learning.api.core.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono; // Added for reactive types

public interface IProduct {

    @GetMapping(value = "/product/{productId}", produces = "application/json")
    @SuppressWarnings("unused")
    Mono<ResponseEntity<ProductDTO>> getProduct(@PathVariable Integer productId); // Changed to Mono
}