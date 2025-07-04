package edu.learning.api.composite.product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
public interface IProductComposite {
    @GetMapping(
            value = "/product-composite/{productId}",
            produces = "application/json")
    ProductCompositeDTO getProduct(@PathVariable int productId);
}