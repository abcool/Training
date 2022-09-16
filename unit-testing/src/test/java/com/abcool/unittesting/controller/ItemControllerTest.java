package com.abcool.unittesting.controller;

import com.abcool.unittesting.model.Item;
import com.abcool.unittesting.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(value= SpringExtension.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService service;

    @Test
    public void item_basic(){
        RequestBuilder request = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
        try{
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"id\":1,\"itemName\":\"Jelly\",\"quantity\":5,\"price\":10.5}"))
                     .andReturn();
        }catch (Exception e){
            System.out.println("Exception occurred while calling API");
        }
    }
    @Test
    public void item_service_layer(){
        when(service.retrieveItem()).thenReturn(new Item(1,"Jelly",5,10.5));

        RequestBuilder request = MockMvcRequestBuilders.get("/item-from-service").accept(MediaType.APPLICATION_JSON);
        try{
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"id\":1,\"itemName\":\"Jelly\",\"quantity\":5,\"price\":10.5}"))
                    .andReturn();
        }catch (Exception e){
            System.out.println("Exception occurred while calling API");
        }
    }
    @Test
    public void getAllItems_basic(){
        when(service.getAllItems()).thenReturn(Arrays.asList(
                new Item(100,"Jelly",5,10.5),
                new Item(101,"Mint Candy",20,5.5)));

        RequestBuilder request = MockMvcRequestBuilders.get("/all-items").accept(MediaType.APPLICATION_JSON);
        try{
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("[{id:100,name:Jelly,quantity:5,price:10.5},{}]"))
                    .andReturn();
        }catch (Exception e){
            System.out.println("Exception occurred while calling API");
        }
    }
    @Test
    public void postItem_basic(){
        when(service.save(new Item(100,"Jelly",5,10.5))).thenReturn(
                new Item(100,"Jelly",5,10.5));

        RequestBuilder request = MockMvcRequestBuilders.post("/item")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":100,\"name\":\"Jelly Bean\",\"quantity\":20,\"price\":10.5}")
                .contentType(MediaType.APPLICATION_JSON);
        try{
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("{id:100,name:Jelly,quantity:5,price:10.5},{}"))
                    .andReturn();
        }catch (Exception e){
            System.out.println("Exception occurred while calling API");
        }
    }
}
