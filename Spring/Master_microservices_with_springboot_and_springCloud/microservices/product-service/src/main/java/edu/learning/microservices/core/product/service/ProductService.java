package edu.learning.microservices.core.product.service;

import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.core.product.mapper.ProductMapper;
import edu.learning.microservices.core.product.persistence.ProductRepository;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ProductService implements IProduct {

    private static final Logger log = LogManager.getLogger(ProductService.class);

    private final ServiceUtil serviceUtil;

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ServiceUtil serviceUtil,
                          ProductRepository productRepository,
                          ProductMapper productMapper) {
        this.serviceUtil = serviceUtil;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<ResponseEntity<ProductDTO>> getProduct(Integer productId) {
        if (productId < 1) {
            return Mono.error(new InvalidInputException("Invalid productId: " + productId));
        }

        return productRepository.findByProductId(productId)
                .map(productMapper::entityToDto)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .switchIfEmpty(Mono.error(new NotFoundException("No product found for productId: " + productId)));
    }

    /**
     * @param productDTO
     * @return
     */
    @Override
    public Mono<ResponseEntity<ProductDTO>> createProduct(ProductDTO productDTO) {
        var productEntity = productMapper.dtoToEntity(productDTO);

        return productRepository.save(productEntity)
                .map(entity -> {
                    log.debug("createProduct: entity created for productId: {}", productDTO.getProductId());
                    return productMapper.entityToDto(entity);
                })
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
                .onErrorMap(DuplicateKeyException.class,
                        ex -> new InvalidInputException("Duplicate key, Product Id: " + productDTO.getProductId()));
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public Mono<ResponseEntity<Void>> deleteProduct(Integer productId) {
        return productRepository.findByProductId(productId)
                .switchIfEmpty(Mono.error(new NotFoundException("No product found for productId: " + productId)))
                .flatMap(entity -> productRepository.delete(entity))
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
    }
}