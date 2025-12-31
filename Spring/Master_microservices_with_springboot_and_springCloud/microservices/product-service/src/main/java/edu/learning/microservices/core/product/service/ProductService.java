package edu.learning.microservices.core.product.service;

import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ProductService implements IProduct {

    private static final Logger log = LogManager.getLogger(ProductService.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public ProductService(ServiceUtil serviceUtil){
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Mono<ResponseEntity<ProductDTO>> getProduct(Integer productId) {
        if (productId < 1) {
            return Mono.error(new InvalidInputException("Invalid productId: " + productId));
        }

        if (productId == 13) {
            return Mono.error(new NotFoundException("No product found for productId: " + productId));
        }
        var product = new ProductDTO(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
        return Mono.just(new ResponseEntity<ProductDTO>(product, HttpStatus.OK));
    }
}