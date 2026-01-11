package edu.learning.microservices.core.product.mapper;

import edu.learning.api.core.product.ProductDTO;
import edu.learning.microservices.core.product.persistence.ProductEntity;
import edu.learning.util.http.ServiceUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    protected ServiceUtil serviceUtil;

    @Autowired
    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Mappings({
            @Mapping(target = "serviceAddress", expression = "java(serviceUtil.getServiceAddress())")
    })
    public abstract ProductDTO entityToDto(ProductEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true), // ✅ Ignore MongoDB _id field
            @Mapping(target = "version", ignore = true) // ✅ Ignore version field
    })
    public abstract ProductEntity dtoToEntity(ProductDTO dto);
}