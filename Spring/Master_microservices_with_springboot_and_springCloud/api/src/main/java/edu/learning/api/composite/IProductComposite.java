package edu.learning.api.composite;

import edu.learning.api.composite.dto.ProductCompositeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProductComposite {
    @GetMapping(
            value = "/product-composite/{productId}",
            produces = "application/json")
    ResponseEntity<ProductCompositeDTO> getCompositeProduct(@PathVariable int productId);
}
