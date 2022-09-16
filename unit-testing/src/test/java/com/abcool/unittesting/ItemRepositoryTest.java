package com.abcool.unittesting;

import com.abcool.unittesting.model.Item;
import com.abcool.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        List<Item> items = repository.findAll();
        assertEquals(3,items.size());
    }

    @Test
    public void testFindOne(){
        Example<Item> t = Example.of(new Item(100,"Jelly Bean",20,10.5));
        Item item = repository.findOne(t).get();
        assertEquals(20,item.getQuantity());
    }
    @Test
    public void testFindById(){
        Item item = repository.findById(101).get();
        assertEquals(200,item.getQuantity());
    }
}
