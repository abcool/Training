package com.abcool.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void hamcrestDemo(){
        List<Integer> nums = Arrays.asList(5,10,15,20);
        assertThat(nums,hasSize(4));
        assertThat(nums,hasItems(5,15));
        assertThat(nums,everyItem(greaterThan(2)));
        assertThat(nums,everyItem(lessThan(50)));
        assertThat("",isEmptyString());
        assertThat("LMNP",containsString("MN"));
        assertThat("PQRS",startsWith("PQ"));
        assertThat("XYZW",endsWith("ZW"));
    }
}
