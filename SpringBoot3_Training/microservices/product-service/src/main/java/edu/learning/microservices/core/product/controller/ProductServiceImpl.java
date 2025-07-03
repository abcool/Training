package edu.learning.microservices.core.product.controller;

import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements IProduct {
    private final ServiceUtil serviceUtil;
    private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);
    @Autowired
    public ProductServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    @Override
    public ProductDTO getProduct(int productId) {
        LOGGER.info("Product Service getProduct called with productId: {}", productId);
        if(productId<1)
            throw new InvalidInputException("Invalid productId: " + productId);
        if(productId==13)
            throw new NotFoundException("No product found for productId: " + productId);
        return new ProductDTO(productId,"name-",123, serviceUtil.getServiceAddress());
    }
}
