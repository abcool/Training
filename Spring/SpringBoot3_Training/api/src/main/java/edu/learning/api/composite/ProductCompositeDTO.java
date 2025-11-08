package edu.learning.api.composite;
import java.util.List;
public record ProductCompositeDTO(int productId, String name, int weight, List<RecommendationSummaryDTO> recommendations,
                                  List<ReviewSummaryDTO> reviews, ServiceAddressDTO serviceAddresses){}