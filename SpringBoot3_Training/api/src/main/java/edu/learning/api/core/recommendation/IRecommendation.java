package edu.learning.api.core.recommendation;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Tag(name = "Recommendation API", description = "Rest API for product recommendations information")
public interface IRecommendation {
    @Operation(summary = "${api.recommendations.getRecommendations.description}",description = "${api.recommendations.getRecommendations.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.recommendations.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "400", description = "${api.recommendations.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "404", description = "${api.recommendations.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "422", description = "${api.recommendations.responseCodes.unprocessableEntity.description}")
    })
    @GetMapping(
            value = "/recommendation",
            produces = "application/json")
    List<RecommendationDTO> getRecommendations(
            @RequestParam(value = "productId", required = true) int productId);
}