package com.abcool.unittesting.service;

import com.abcool.unittesting.repository.ItemRepository;
import com.abcool.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public Item retrieveItem(){
        return new Item(1,"Jelly",5,10.50);
    }

    public List<Item> getAllItems(){
        List<Item> items = repository.findAll();
        items.stream().forEach(x->x.setValue(x.getPrice() * x.getQuantity()));
        return items;
    }

    public Item save(Item item) {
        Item result = repository.save(item);
        result.setValue(result.getQuantity()* result.getPrice());
        return result;
    }
}
