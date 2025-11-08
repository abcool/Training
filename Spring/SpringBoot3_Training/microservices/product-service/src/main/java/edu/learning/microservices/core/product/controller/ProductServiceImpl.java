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
import reactor.core.publisher.Mono;

import java.util.logging.Level;

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
    public Mono<ProductDTO> createProduct(ProductDTO body) {
        LOGGER.debug("Create product: Received request payload: "+ body);
        try {
            ProductEntity entity = mapper.dtoToEntity(body);
            Mono<ProductDTO> newEntity = repository.save(entity)
                    .log(LOGGER.getName(), Level.FINE)
                    .onErrorMap(DuplicateKeyException.class,
                            ex-> new InvalidInputException("Duplicate key, Product Id: " + body.productId()))
                    .map(e-> mapper.entityToDTO(e));

            LOGGER.debug("createProduct: entity created for productId: {}", body.productId());
            return newEntity;

        } catch (DuplicateKeyException dke) {
            throw new InvalidInputException("Duplicate key, Product Id: " + body.productId());
        }
    }


    @Override
    public Mono<ProductDTO> getProduct(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        return repository.findByProductId(productId)
                .switchIfEmpty(Mono.error(new NotFoundException("No product found for productId: " + productId)))
                .log(LOGGER.getName(), Level.FINE)
                .map(e-> mapper.entityToDTO(e))
                .map(dto -> new ProductDTO(productId,dto.name(), dto.weight(), serviceUtil.getServiceAddress()));
    }

    @Override
    public Mono<Void> deleteProduct(int productId) {
        LOGGER.debug("deleteProduct: tries to delete an entity with productId: {}", productId);
        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }
        return repository.findByProductId(productId)
                .log(LOGGER.getName(), Level.FINE)
                .map(product -> repository.delete(product))
                .flatMap(product -> product);
    }
}