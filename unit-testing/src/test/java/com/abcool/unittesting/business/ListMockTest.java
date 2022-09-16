package com.abcool.unittesting.business;


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }
    @Test
    public void size_MultipleValues(){
        when(mock.size()).thenReturn(5).thenReturn(10).thenReturn(15);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
        assertEquals(15,mock.size());
    }
    @Test
    public void returnWithPrams(){
        when(mock.get(anyInt())).thenReturn("test passed");
        assertEquals("test passed",mock.get(0));
        assertEquals("test passed",mock.get(1));
        assertEquals("test passed",mock.get(2000));
    }
    @Test
    public void verificationBasics(){
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(1);
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,never()).get(5);
    }

    /**
     * @apiNote This test method checks whether the value passed is equal to the one supplied
     */
    @Test
    public void argumentCapture(){
        mock.add("Some Value");
        // create an argument capture to catch String values
        ArgumentCaptor<String> capture = ArgumentCaptor.forClass(String.class);
        verify(mock).add(capture.capture());
        // checks the value added to mock list on line 54 equals to Some Value
        assertEquals("Some Value",capture.getValue());
    }
    @Test
    public void multipleArgumentCapture(){
        mock.add("Some Value 1");
        mock.add("Some Value 2");
        // create an argument capture to catch String values
        ArgumentCaptor<String> capture = ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(capture.capture());
        // checks the value added to mock list on line 54 equals to Some Value
        List<String> allValues = capture.getAllValues();
        assertEquals("Some Value 1", allValues.get(0));
    }

    @Test
    public void mocking(){
        ArrayList arrayMock = mock(ArrayList.class);
        System.out.println(arrayMock.get(0));
        System.out.println(arrayMock.size());
        arrayMock.add("Value 1");
        arrayMock.add("Value 2");
        System.out.println("After adding 2 values, size= "+arrayMock.size());
        when(arrayMock.size()).thenReturn(5);
        System.out.println(arrayMock.size());
    }

    @Test
    public void spying(){
        ArrayList spy = spy(ArrayList.class);
        System.out.println(spy.size());
        spy.add("Value 1");
        spy.add("Value 2");
        System.out.println("After adding 2 values, size= "+spy.size());
        when(spy.size()).thenReturn(5);
        System.out.println(spy.size());
        assertEquals(5,spy.size());
        verify(spy).add("Value 1");
        verify(spy,times(4)).size();
    }
}
