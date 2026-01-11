package edu.learning.api.core.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono; // Added for reactive types

public interface IProduct {

    @GetMapping(value = "/product/{productId}", produces = "application/json")
    @SuppressWarnings("unused")
    Mono<ResponseEntity<ProductDTO>> getProduct(@PathVariable Integer productId); // Changed to Mono

    @PostMapping(value = "/product", consumes = "application/json", produces = "application/json")
    @SuppressWarnings("unused")
    Mono<ResponseEntity<ProductDTO>> createProduct(@RequestBody  ProductDTO body);

    @DeleteMapping(value = "/product/{productId}")
    @SuppressWarnings("unused")
    Mono<ResponseEntity<Void>> deleteProduct(@PathVariable Integer productId); // Changed to Mono
}