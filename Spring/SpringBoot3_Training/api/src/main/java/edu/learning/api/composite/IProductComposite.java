package edu.learning.api.composite;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Composite API", description = "Rest API for product composite information")
public interface IProductComposite {

    @Operation(
            summary = "${api.productComposite.create-composite-product.description}",
            description = "${api.productComposite.create-composite-product.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "${api.productComposite.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "422", description = "${api.productComposite.responseCodes.unprocessableEntity.description}")
    })
    @PostMapping(
            value    = "/product-composite",
            consumes = "application/json")
    ProductCompositeDTO createProduct(@RequestBody ProductCompositeDTO body);
    @Operation(summary = "${api.productComposite.getCompositeProduct.description}",
            description = "${api.productComposite.getCompositeProduct.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.productComposite.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "400", description = "${api.productComposite.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "404", description = "${api.productComposite.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "422", description = "${api.productComposite.responseCodes.unprocessableEntity.description}")
    })
    @GetMapping(
            value = "/product-composite/{productId}",
            produces = "application/json")
    ProductCompositeDTO getProduct(@PathVariable int productId);

    @Operation(
            summary = "${api.productComposite.delete-composite-product.description}",
            description = "${api.productComposite.delete-composite-product.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "${api.productComposite.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "422", description = "${api.productComposite.responseCodes.unprocessableEntity.description}")
    })
    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteProduct(@PathVariable int productId);
}