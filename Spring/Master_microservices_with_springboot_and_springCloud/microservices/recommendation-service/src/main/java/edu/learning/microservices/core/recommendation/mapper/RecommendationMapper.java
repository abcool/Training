package edu.learning.microservices.core.recommendation.mapper;

import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.microservices.core.recommendation.persistence.RecommendationEntity;
import edu.learning.util.http.ServiceUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RecommendationMapper {

    protected ServiceUtil serviceUtil;

    @Autowired
    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Mappings({
            @Mapping(target = "rate", source = "rating"),
            @Mapping(target = "serviceAddress", expression = "java(serviceUtil.getServiceAddress())")
    })
    public abstract RecommendationDTO entityToDto(RecommendationEntity entity);

    @Mappings({
            @Mapping(target = "rating", source = "rate"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true)
    })
    public abstract RecommendationEntity dtoToEntity(RecommendationDTO recommendationDTO);

    public abstract List<RecommendationDTO> entityListToDtoList(List<RecommendationEntity> entity);

    public abstract List<RecommendationEntity> dtoListToEntityList(List<RecommendationDTO> api);
}