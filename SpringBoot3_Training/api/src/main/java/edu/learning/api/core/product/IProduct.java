package edu.learning.api.core.product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product API", description = "Rest API for product information")
public interface IProduct{

    @PostMapping(
            value    = "/product",
            consumes = "application/json",
            produces = "application/json")
    ProductDTO createProduct(@RequestBody ProductDTO body);

    @Operation(summary = "${api.product.getProduct.description}", description = "${api.product.getProduct.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.product.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "400",description = "${api.product.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "404", description = "${api.product.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "422", description = "${api.product.responseCodes.unprocessableEntity.description}")
    })
    @GetMapping(
            value = "/product/{productId}",
            produces = "application/json")
    ProductDTO getProduct(@PathVariable int productId);

    @DeleteMapping(value = "/product/{productId}")
    void deleteProduct(@PathVariable int productId);
}