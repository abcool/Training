package edu.learning.microservices.core.review.mapper;

import edu.learning.api.core.review.ReviewDTO;
import edu.learning.microservices.core.review.persistence.ReviewEntity;
import edu.learning.util.http.ServiceUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReviewMapper {

    protected ServiceUtil serviceUtil;

    @Autowired
    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Mappings({
            @Mapping(target = "serviceAddress", expression = "java(serviceUtil.getServiceAddress())")
    })
    public abstract ReviewDTO entityToDto(ReviewEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true)
    })
    public abstract ReviewEntity dtoToEntity(ReviewDTO reviewDTO);

    public abstract List<ReviewDTO> entityListToDtoList(List<ReviewEntity> entities);

    public abstract List<ReviewEntity> dtoListToEntityList(List<ReviewDTO> reviews);
}
