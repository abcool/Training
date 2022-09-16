package com.abcool.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSonAssertTest {
    String actualResponse = "{\"id\":1,\"itemName\":\"Jelly\",\"quantity\":5,\"price\":10.5}";

    @Test
    public void jsonAssertStrict(){
        String expectedResponse = "{\"id\":1,\"itemName\":\"Jelly\",\"quantity\":5,\"price\":10.5}";
        try {
            JSONAssert.assertEquals(expectedResponse,actualResponse,true);
        } catch (JSONException e) {
            System.out.println("Error occurred while comparing responses");
        }
    }
    @Test
    public void jsonAssert(){
        String expectedResponse = "{\"id\":1,\"itemName\":\"Jelly\",\"quantity\":5}";
        try {
            JSONAssert.assertEquals(expectedResponse,actualResponse,false);
        } catch (JSONException e) {
            System.out.println("Error occurred while comparing responses");
        }
    }

    @Test
    public void jsonAssertWithoutEscapingQuotes(){
        String expectedResponse1 = "{id:1, itemName:Jelly, quantity:5}";
        String expectedResponse2 = "{id:1, itemName:Jelly, quantity:5, price:10.5}";
        try {
            JSONAssert.assertEquals(expectedResponse1,actualResponse,false);
            JSONAssert.assertEquals(expectedResponse2,actualResponse,true);
        } catch (JSONException e) {
            System.out.println("Error occurred while comparing responses");
        }
    }
}
