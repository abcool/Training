package edu.learning.api.composite;

import edu.learning.api.composite.dto.ProductCompositeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono; // Added for reactive types
@Tag(name = "Product Composite Service", description = "This API gets you complete information for the product")
public interface IProductComposite {
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
            value = "/product-composite/{productId}",
            produces = "application/json")
    Mono<ResponseEntity<ProductCompositeDTO>> getCompositeProduct(@PathVariable int productId); // Changed to Mono
}
