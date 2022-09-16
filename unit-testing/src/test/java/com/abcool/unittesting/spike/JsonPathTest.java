package com.abcool.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void demo_basic(){
        String response = "[{\"id\":100,\"name\":\"Jelly Bean\",\"quantity\":20,\"price\":10.5,\"value\":210.0},{\"id\":101,\"name\":\"Mint Candy\",\"quantity\":200,\"price\":2.5,\"value\":500.0},{\"id\":102,\"name\":\"Bubble Gum\",\"quantity\":100,\"price\":3.5,\"value\":350.0}]";
        DocumentContext context = JsonPath.parse(response);
        int len = context.read("$.length()");
        assertThat(len).isEqualTo(3);
        List<Integer> ids = context.read("$..id");
        System.out.println(ids);
        assertThat(ids).containsExactly(100,101,102);
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[1:2]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.price==10.5)]").toString());
    }
}
