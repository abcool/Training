package edu.learning.api.core.review;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Tag(name = "Review API", description = "Rest API for product reviews information")
public interface IReview{
    @Operation(summary = "${api.reviews.getReviews.description}", description = "${api.reviews.getReviews.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.reviews.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "400", description = "${api.reviews.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "404", description = "${api.reviews.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "422", description = "${api.reviews.responseCodes.unprocessableEntity.description}")
    })
    @GetMapping(
            value = "/review",
            produces = "application/json")
    List<ReviewDTO> getReviews(@RequestParam(value = "productId", required = true) int productId);
}