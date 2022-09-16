package com.abcool.unittesting.business;

import com.abcool.unittesting.data.ISomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class SomeBusinessTest {

    @InjectMocks
    private SomeBusinessImpl business;
    @Mock
    // create a mock object
    private ISomeDataService dataServiceMock;

//    //map that object to the member of SomeBusinessImpl class
//    @BeforeEach
//    public void before(){
//        business.setDataService(dataServiceMock);
//    }


    @Test
    public void calculateSum_HappyCase(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualSum = business.returnSum(new int[]{1,2,3,4,5});
        int expectedSum = 15;
        assertEquals(expectedSum,actualSum);
    }
    @Test
    public void calculateSum_emptyArray(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualSum = business.returnSum(new int[]{});
        int expectedSum = 0;
        assertEquals(expectedSum,actualSum);
    }
    @Test
    public void calculateSum_OneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualSum = business.returnSum(new int[]{5});
        int expectedSum = 5;
        assertEquals(expectedSum,actualSum);
    }
    @Test
    public void calculateSum_FromData(){

        // when the method retrieveData() of that mock object is called return array containing elements 1,2 & 3
        when(dataServiceMock.retrieveData()).thenReturn(new int[]{1,2,3});
        // here we are calling retrieveData() indirectly via the object business
        int actualSum = business.returnSumUsingDataService();
        int expectedSum = 6;
        assertEquals(expectedSum,actualSum);
    }
    @Test
    public void calculateSumFromData_emptyArray(){
        when(dataServiceMock.retrieveData()).thenReturn(new int[]{});
        int actualSum = business.returnSumUsingDataService();
        int expectedSum = 0;
        assertEquals(expectedSum,actualSum);
    }
    @Test
    public void calculateSumFromData_OneValue(){
        when(dataServiceMock.retrieveData()).thenReturn(new int[]{5});
        int actualSum = business.returnSumUsingDataService();
        int expectedSum = 5;
        assertEquals(expectedSum,actualSum);
    }
}
