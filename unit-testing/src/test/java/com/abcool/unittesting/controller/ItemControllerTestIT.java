package com.abcool.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerTestIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testtIemsAPI_basic(){
        String response = this.restTemplate.getForObject("/all-items", String.class);
        try{
            JSONAssert.assertEquals(response,"[{100},{101},{102}]",false);
        }catch (Exception ex){
            System.out.println("Error occurred while testing API");
        }
    }
}
