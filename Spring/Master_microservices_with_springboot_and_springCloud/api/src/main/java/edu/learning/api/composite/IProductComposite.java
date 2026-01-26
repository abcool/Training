package edu.learning.api.composite;

import edu.learning.api.composite.dto.ProductCompositeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono; // Added for reactive types
@Tag(name = "Product Composite Service", description = "This API gets you complete information for the product")
@RequestMapping("/product-composite")
public interface IProductComposite {

    /**
     * Sample usage, see below.
     *
     * curl -X POST $HOST:$PORT/product-composite \
     *   -H "Content-Type: application/json" --data \
     *   '{"productId":123,"name":"product 123","weight":123}'
     *
     * @param productCompositeDTO A JSON representation of the new composite product
     */
    @Operation(
            summary = "${product-composite-service.summary}",
            description = "${product-composite-service.description}"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "${product-composite-service.badRequest.description}"),
            @ApiResponse(responseCode = "422", description = "${product-composite-service.unprocessableEntity.description}")
    })
    @PostMapping(consumes = "application/json")
    Mono<ResponseEntity<ProductCompositeDTO>> createProduct(@RequestBody ProductCompositeDTO productCompositeDTO);

    @Operation(
            summary = "${product-composite-service.summary}",
            description = "${product-composite-service.description}"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${product-composite-service.ok.description}"),
            @ApiResponse(responseCode = "400", description = "${product-composite-service.badRequest.description}"),
            @ApiResponse(responseCode = "404", description = "${product-composite-service.notFound.description}"),
            @ApiResponse(responseCode = "422", description = "${product-composite-service.unprocessableEntity.description}")
    }
    )
    @GetMapping(
            value = "/{productId}",
            produces = "application/json")
    Mono<ResponseEntity<ProductCompositeDTO>> getCompositeProduct(@PathVariable int productId); // Changed to Mono

    /**
     * Sample usage: "curl -X DELETE $HOST:$PORT/product-composite/1".
     *
     * @param productId Id of the product
     */
    @Operation(
            summary = "${product-composite-service.summary}",
            description = "${product-composite-service.description}"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "${product-composite-service.badRequest.description}"),
            @ApiResponse(responseCode = "422", description = "${product-composite-service.unprocessableEntity.description}")
    })
    @DeleteMapping(value = "/{productId}")
    Mono<ResponseEntity<Void>> deleteProduct(@PathVariable int productId);
}
