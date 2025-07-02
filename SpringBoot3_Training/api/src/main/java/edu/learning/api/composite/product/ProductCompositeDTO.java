package edu.learning.api.composite.product;
import java.util.List;
public record ProductCompositeDTO(int productId, String name, int weight, List<RecommendationSummaryDTO> recommendations,
                                  List<ReviewSummaryDTO> reviews, ServiceAddressDTO serviceAddresses){}