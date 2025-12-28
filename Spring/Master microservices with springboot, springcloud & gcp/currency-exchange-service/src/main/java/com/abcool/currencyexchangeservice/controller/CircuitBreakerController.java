package com.abcool.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    //@Retry(name="sample-api",fallbackMethod = "handleFailure")
    @CircuitBreaker(name="default",fallbackMethod = "handleFailure")
    public String sampleAPI2(){
        logger.info("Sample API called");
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/dummy-url",String.class);
        return entity.getBody();
    }

    private String handleFailure(Exception ex){
        return "retry failed";
    }
}
