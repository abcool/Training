package com.abcool.unittesting.service;

import com.abcool.unittesting.business.SomeBusinessImpl;
import com.abcool.unittesting.data.ISomeDataService;
import com.abcool.unittesting.model.Item;
import com.abcool.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ItemServiceTest {

    @InjectMocks
    private ItemService service;
    @Mock
    // create a mock object
    private ItemRepository repoMock;

    @Test
    public void getAllItemsBasic(){
        when(repoMock.findAll()).thenReturn(Arrays.asList(
                new Item(100,"Jelly",5,10.5),
                new Item(101,"Mint Candy",20,5.5)));
        List<Item> actualItems = service.getAllItems();
        List<Item> expectedItems = Arrays.asList(
                new Item(100,"Jelly",5,10.5),
                new Item(101,"Mint Candy",20,5.5));
        assertEquals(52.5,actualItems.get(0).getValue());
        assertEquals(110,actualItems.get(1).getValue());
    }
}
