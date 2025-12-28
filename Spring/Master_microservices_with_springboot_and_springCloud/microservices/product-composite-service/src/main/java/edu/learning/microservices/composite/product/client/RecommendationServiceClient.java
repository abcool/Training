package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.recommendation.RecommendationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url="${recommendation-service-url}", name="recommendation-service-client")
public interface RecommendationServiceClient {

    @GetMapping(path = "/recommendation")
    List<RecommendationDTO> getRecommendations(@RequestParam(name = "productId") int productId);
}
