package edu.learning.microservices.core.review.controller;

import java.util.List;

import edu.learning.api.core.review.ReviewDTO;
import edu.learning.microservices.core.review.persistence.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true)
    })
    ReviewDTO entityToDto(ReviewEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true)
    })
    ReviewEntity dtoToEntity(ReviewDTO api);

    List<ReviewDTO> entityListToDtoList(List<ReviewEntity> entity);

    List<ReviewEntity> dtoListToEntityList(List<ReviewDTO> api);
}
