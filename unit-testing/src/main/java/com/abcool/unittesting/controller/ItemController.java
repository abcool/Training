package com.abcool.unittesting.controller;

import com.abcool.unittesting.model.Item;
import com.abcool.unittesting.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping("/item")
    public Item getItem(){
        return new Item(1,"Jelly",5,10.50);
    }

    @GetMapping("/item-from-service")
    public Item getItemFromService(){
        return service.retrieveItem();
    }

    @GetMapping(path = "/all-items")
    public List<Item> getAllItems(){
        return service.getAllItems();
    }

    @PostMapping(path = "/item")
    public Item saveItem(@RequestBody Item item){
        return service.save(item);
    }
}
