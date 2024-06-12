package edu.learning.microservices.core.product.services;
import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.ServiceUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements IProduct {

    private static final Logger log = LogManager.getLogger(ProductServiceImpl.class);

    private final ServiceUtility serviceUtil;

    @Autowired
    public ProductServiceImpl(ServiceUtility serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public ProductDTO getProduct(int productId) {
        log.info("product found for productId {}", productId);
        if(productId<1)
            throw new InvalidInputException("Invalid productId: "+ productId);
        if(productId==13)
            throw new NotFoundException("Product with productId: "+productId +" not found");
        return new ProductDTO(productId, "name-"+ productId, 123, serviceUtil.getServiceAddress());
    }
}
