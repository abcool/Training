package edu.learning.microservices.core.recommendation.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.microservices.core.recommendation.controller.RecommendationMapper;
import edu.learning.microservices.core.recommendation.persistence.RecommendationEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


class MapperTests {

    private RecommendationMapper mapper = Mappers.getMapper(RecommendationMapper.class);

    @Test
    void mapperTests() {

        assertNotNull(mapper);

        RecommendationDTO dto = new RecommendationDTO(1, 2, "a", 4, "C", "adr");

        RecommendationEntity entity = mapper.apiToEntity(dto);

        assertEquals(dto.productId(), entity.getProductId());
        assertEquals(dto.recommendationId(), entity.getRecommendationId());
        assertEquals(dto.author(), entity.getAuthor());
        assertEquals(dto.rate(), entity.getRating());
        assertEquals(dto.content(), entity.getContent());

        RecommendationDTO dto2 = mapper.entityToApi(entity);

        assertEquals(dto.productId(), dto2.productId());
        assertEquals(dto.recommendationId(), dto2.recommendationId());
        assertEquals(dto.author(), dto2.author());
        assertEquals(dto.rate(), dto2.rate());
        assertEquals(dto.content(), dto2.content());
        assertNull(dto2.serviceAddress());
    }

    @Test
    void mapperListTests() {

        assertNotNull(mapper);

        RecommendationDTO dto = new RecommendationDTO(1, 2, "a", 4, "C", "adr");
        List<RecommendationDTO> dtoList = Collections.singletonList(dto);

        List<RecommendationEntity> entityList = mapper.apiListToEntityList(dtoList);
        assertEquals(dtoList.size(), entityList.size());

        RecommendationEntity entity = entityList.get(0);

        assertEquals(dto.productId(), entity.getProductId());
        assertEquals(dto.recommendationId(), entity.getRecommendationId());
        assertEquals(dto.author(), entity.getAuthor());
        assertEquals(dto.rate(), entity.getRating());
        assertEquals(dto.content(), entity.getContent());

        List<RecommendationDTO> dto2List = mapper.entityListToApiList(entityList);
        assertEquals(dtoList.size(), dto2List.size());

        RecommendationDTO dto2 = dto2List.get(0);

        assertEquals(dto.productId(), dto2.productId());
        assertEquals(dto.recommendationId(), dto2.recommendationId());
        assertEquals(dto.author(), dto2.author());
        assertEquals(dto.rate(), dto2.rate());
        assertEquals(dto.content(), dto2.content());
        assertNull(dto2.serviceAddress());
    }
}
