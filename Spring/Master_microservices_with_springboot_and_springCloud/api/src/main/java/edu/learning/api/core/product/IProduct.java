package edu.learning.api.core.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProduct {

    @GetMapping(value = "product/{productId}", produces = "application/json")
    @SuppressWarnings("unused")
    ProductDTO getProduct(@PathVariable Integer productId);
}
