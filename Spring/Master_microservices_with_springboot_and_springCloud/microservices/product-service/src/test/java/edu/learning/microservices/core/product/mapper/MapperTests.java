package edu.learning.microservices.core.product.mapper;

import edu.learning.api.core.product.ProductDTO;
import edu.learning.microservices.core.product.persistence.ProductEntity;
import edu.learning.util.http.ServiceUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MapperTests {

    @Autowired
    private ProductMapper mapper;

    @MockitoBean
    private ServiceUtil serviceUtil;

    @Test
    void mapperTests() {
        assertNotNull(mapper);

        // Mock the ServiceUtil
        when(serviceUtil.getServiceAddress()).thenReturn("mocked-address");

        // Create test DTO
        ProductDTO productDTO = new ProductDTO(1, "n", 1, "sa");

        // Map DTO to Entity
        ProductEntity entity = mapper.dtoToEntity(productDTO);

        // Verify DTO -> Entity mapping
        assertNotNull(entity);
        assertEquals(productDTO.getProductId(), entity.getProductId());
        assertEquals(productDTO.getName(), entity.getName());
        assertEquals(productDTO.getWeight(), entity.getWeight());

        // Map Entity back to DTO
        ProductDTO productDTO2 = mapper.entityToDto(entity);

        // Verify Entity -> DTO mapping
        assertNotNull(productDTO2);
        assertEquals(productDTO.getProductId(), productDTO2.getProductId());
        assertEquals(productDTO.getName(), productDTO2.getName());
        assertEquals(productDTO.getWeight(), productDTO2.getWeight());
        assertEquals("mocked-address", productDTO2.getServiceAddress());
    }
}