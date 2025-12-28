package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.product.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${product-service-url}", name = "product-service-client")
public interface ProductServiceClient {

    @GetMapping(path = "/product/{productId}")
    ProductDTO getProduct(@PathVariable(name = "productId") int productId);

}
