package edu.learning.microservices.core.review.mapper;

import edu.learning.api.core.review.ReviewDTO;
import edu.learning.microservices.core.review.persistence.ReviewEntity;
import edu.learning.util.http.ServiceUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ReviewMapperTests {

    @Autowired
    private ReviewMapper mapper;

    @MockitoBean
    private ServiceUtil serviceUtil;

    @Test
    void mapperTests() {

        assertNotNull(mapper);

        ReviewDTO reviewDTO = new ReviewDTO(1, 2, "a", "s", "C", "adr");

        ReviewEntity entity = mapper.dtoToEntity(reviewDTO);

        assertEquals(reviewDTO.getProductId(), entity.getProductId());
        assertEquals(reviewDTO.getReviewId(), entity.getReviewId());
        assertEquals(reviewDTO.getAuthor(), entity.getAuthor());
        assertEquals(reviewDTO.getSubject(), entity.getSubject());
        assertEquals(reviewDTO.getContent(), entity.getContent());

        ReviewDTO reviewDTO2 = mapper.entityToDto(entity);

        assertEquals(reviewDTO.getProductId(), reviewDTO2.getProductId());
        assertEquals(reviewDTO.getReviewId(), reviewDTO2.getReviewId());
        assertEquals(reviewDTO.getAuthor(), reviewDTO2.getAuthor());
        assertEquals(reviewDTO.getSubject(), reviewDTO2.getSubject());
        assertEquals(reviewDTO.getContent(), reviewDTO2.getContent());
        assertNull(reviewDTO2.getServiceAddress());
    }

    @Test
    void mapperListTests() {

        assertNotNull(mapper);

        ReviewDTO reviewDTO = new ReviewDTO(1, 2, "a", "s", "C", "adr");
        List<ReviewDTO> apiList = Collections.singletonList(reviewDTO);

        List<ReviewEntity> entityList = mapper.dtoListToEntityList(apiList);
        assertEquals(apiList.size(), entityList.size());

        ReviewEntity entity = entityList.get(0);

        assertEquals(reviewDTO.getProductId(), entity.getProductId());
        assertEquals(reviewDTO.getReviewId(), entity.getReviewId());
        assertEquals(reviewDTO.getAuthor(), entity.getAuthor());
        assertEquals(reviewDTO.getSubject(), entity.getSubject());
        assertEquals(reviewDTO.getContent(), entity.getContent());

        List<ReviewDTO> api2List = mapper.entityListToDtoList(entityList);
        assertEquals(apiList.size(), api2List.size());

        ReviewDTO reviewDTO2 = api2List.get(0);

        assertEquals(reviewDTO.getProductId(), reviewDTO2.getProductId());
        assertEquals(reviewDTO.getReviewId(), reviewDTO2.getReviewId());
        assertEquals(reviewDTO.getAuthor(), reviewDTO2.getAuthor());
        assertEquals(reviewDTO.getSubject(), reviewDTO2.getSubject());
        assertEquals(reviewDTO.getContent(), reviewDTO2.getContent());
        assertNull(reviewDTO2.getServiceAddress());
    }
}
