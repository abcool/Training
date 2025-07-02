package edu.learning.microservices.core.product.controller;

import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements IProduct {
    private final ServiceUtil serviceUtil;
    @Autowired
    public ProductServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    @Override
    public ProductDTO getProduct(int productId) {
        return new ProductDTO(productId,"name-",123, serviceUtil.getServiceAddress());
    }
}
