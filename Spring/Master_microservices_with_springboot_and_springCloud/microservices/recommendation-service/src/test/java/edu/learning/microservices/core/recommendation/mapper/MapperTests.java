package edu.learning.microservices.core.recommendation.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.microservices.core.recommendation.persistence.RecommendationEntity;
import edu.learning.util.http.ServiceUtil;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class MapperTests {

    @Autowired
    private RecommendationMapper mapper;

    @MockitoBean
    private ServiceUtil serviceUtil;

    @Test
    void mapperTests() {

        assertNotNull(mapper);

        RecommendationDTO recommendationDTO = new RecommendationDTO(1, 2, "a", 4, "C", "adr");

        RecommendationEntity entity = mapper.dtoToEntity(recommendationDTO);

        assertEquals(recommendationDTO.getProductId(), entity.getProductId());
        assertEquals(recommendationDTO.getRecommendationId(), entity.getRecommendationId());
        assertEquals(recommendationDTO.getAuthor(), entity.getAuthor());
        assertEquals(recommendationDTO.getRate(), entity.getRating());
        assertEquals(recommendationDTO.getContent(), entity.getContent());

        RecommendationDTO recommendationDTO2 = mapper.entityToDto(entity);

        assertEquals(recommendationDTO.getProductId(), recommendationDTO2.getProductId());
        assertEquals(recommendationDTO.getRecommendationId(), recommendationDTO2.getRecommendationId());
        assertEquals(recommendationDTO.getAuthor(), recommendationDTO2.getAuthor());
        assertEquals(recommendationDTO.getRate(), recommendationDTO2.getRate());
        assertEquals(recommendationDTO.getContent(), recommendationDTO2.getContent());
        assertNull(recommendationDTO2.getServiceAddress());
    }

    @Test
    void mapperListTests() {

        assertNotNull(mapper);

        RecommendationDTO api = new RecommendationDTO(1, 2, "a", 4, "C", "adr");
        List<RecommendationDTO> recommendations = Collections.singletonList(api);

        List<RecommendationEntity> entityList = mapper.dtoListToEntityList(recommendations);
        assertEquals(recommendations.size(), entityList.size());

        RecommendationEntity entity = entityList.get(0);

        assertEquals(api.getProductId(), entity.getProductId());
        assertEquals(api.getRecommendationId(), entity.getRecommendationId());
        assertEquals(api.getAuthor(), entity.getAuthor());
        assertEquals(api.getRate(), entity.getRating());
        assertEquals(api.getContent(), entity.getContent());

        List<RecommendationDTO> recommendations2 = mapper.entityListToDtoList(entityList);
        assertEquals(recommendations.size(), recommendations2.size());

        RecommendationDTO api2 = recommendations2.get(0);

        assertEquals(api.getProductId(), api2.getProductId());
        assertEquals(api.getRecommendationId(), api2.getRecommendationId());
        assertEquals(api.getAuthor(), api2.getAuthor());
        assertEquals(api.getRate(), api2.getRate());
        assertEquals(api.getContent(), api2.getContent());
        assertNull(api2.getServiceAddress());
    }
}

