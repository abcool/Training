package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.review.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "${review-service-url}", name="review-service-client")
public interface ReviewServiceClient {

    @GetMapping(path = "/review")
    List<ReviewDTO> getReviews(@RequestParam(name = "productId") int productId);

}
