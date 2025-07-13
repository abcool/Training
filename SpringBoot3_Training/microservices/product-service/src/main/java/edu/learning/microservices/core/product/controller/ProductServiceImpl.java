package edu.learning.microservices.core.product.controller;

import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.core.product.persistence.ProductEntity;
import edu.learning.microservices.core.product.persistence.ProductRepository;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements IProduct {
    private final ServiceUtil serviceUtil;
    private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper, ServiceUtil serviceUtil) {
        this.repository = repository;
        this.mapper = mapper;
        this.serviceUtil = serviceUtil;
    }
    @Override
    public ProductDTO createProduct(ProductDTO body) {
        try {
            ProductEntity entity = mapper.dtoToEntity(body);
            ProductEntity newEntity = repository.save(entity);

            LOGGER.debug("createProduct: entity created for productId: {}", body.productId());
            return mapper.entityToDTO(newEntity);

        } catch (DuplicateKeyException dke) {
            throw new InvalidInputException("Duplicate key, Product Id: " + body.productId());
        }
    }


    @Override
    public ProductDTO getProduct(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        ProductEntity entity = repository.findByProductId(productId)
                .orElseThrow(() -> new NotFoundException("No product found for productId: " + productId));

        ProductDTO response = mapper.entityToDTO(entity);
        response = new ProductDTO(productId,response.name(), response.weight(), serviceUtil.getServiceAddress());

        LOGGER.debug("getProduct: found productId: {}", response.productId());

        return response;
    }

    @Override
    public void deleteProduct(int productId) {
        LOGGER.debug("deleteProduct: tries to delete an entity with productId: {}", productId);
        repository.findByProductId(productId).ifPresent(e -> repository.delete(e));
    }
}