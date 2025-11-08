package edu.learning.microservices.core.product.persistence.helper;

import static org.junit.jupiter.api.Assertions.*;

import edu.learning.api.core.product.ProductDTO;
import edu.learning.microservices.core.product.controller.ProductMapper;
import edu.learning.microservices.core.product.persistence.ProductEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class MapperTests {

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void mapperTests() {

        assertNotNull(mapper);

        ProductDTO dto = new ProductDTO(1, "n", 1, "sa");

        ProductEntity entity = mapper.dtoToEntity(dto);

        assertEquals(dto.productId(), entity.getProductId());
        assertEquals(dto.productId(), entity.getProductId());
        assertEquals(dto.name(), entity.getName());
        assertEquals(dto.weight(), entity.getWeight());

        ProductDTO dto2 = mapper.entityToDTO(entity);

        assertEquals(dto.productId(), dto2.productId());
        assertEquals(dto.name(),      dto2.name());
        assertEquals(dto.weight(),    dto2.weight());
        assertNull(dto2.serviceAddress());
    }
}
