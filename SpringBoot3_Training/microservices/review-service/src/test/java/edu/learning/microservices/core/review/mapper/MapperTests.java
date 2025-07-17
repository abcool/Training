package edu.learning.microservices.core.review.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.microservices.core.review.controller.ReviewMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import edu.learning.microservices.core.review.persistence.ReviewEntity;


class MapperTests {

    private ReviewMapper mapper = Mappers.getMapper(ReviewMapper.class);

    @Test
    void mapperTests() {

        assertNotNull(mapper);

        ReviewDTO dto = new ReviewDTO(1, 2, "a", "s", "C", "adr");

        ReviewEntity entity = mapper.dtoToEntity(dto);

        assertEquals(dto.productId(), entity.getProductId());
        assertEquals(dto.reviewId(), entity.getReviewId());
        assertEquals(dto.author(), entity.getAuthor());
        assertEquals(dto.subject(), entity.getSubject());
        assertEquals(dto.content(), entity.getContent());

        ReviewDTO dto2 = mapper.entityToDto(entity);

        assertEquals(dto.productId(), dto2.productId());
        assertEquals(dto.reviewId(), dto2.reviewId());
        assertEquals(dto.author(), dto2.author());
        assertEquals(dto.subject(), dto2.subject());
        assertEquals(dto.content(), dto2.content());
        assertNull(dto2.serviceAddress());
    }

    @Test
    void mapperListTests() {

        assertNotNull(mapper);

        ReviewDTO dto = new ReviewDTO(1, 2, "a", "s", "C", "adr");
        List<ReviewDTO> dtoList = Collections.singletonList(dto);

        List<ReviewEntity> entityList = mapper.dtoListToEntityList(dtoList);
        assertEquals(dtoList.size(), entityList.size());

        ReviewEntity entity = entityList.get(0);

        assertEquals(dto.productId(), entity.getProductId());
        assertEquals(dto.reviewId(), entity.getReviewId());
        assertEquals(dto.author(), entity.getAuthor());
        assertEquals(dto.subject(), entity.getSubject());
        assertEquals(dto.content(), entity.getContent());

        List<ReviewDTO> dto2List = mapper.entityListToDtoList(entityList);
        assertEquals(dtoList.size(), dto2List.size());

        ReviewDTO dto2 = dto2List.get(0);

        assertEquals(dto.productId(), dto2.productId());
        assertEquals(dto.reviewId(), dto2.reviewId());
        assertEquals(dto.author(), dto2.author());
        assertEquals(dto.subject(), dto2.subject());
        assertEquals(dto.content(), dto2.content());
        assertNull(dto2.serviceAddress());
    }
}
