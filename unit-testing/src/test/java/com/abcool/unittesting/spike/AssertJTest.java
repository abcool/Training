package com.abcool.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void assertJDemo(){
        List<Integer> nums = Arrays.asList(5,19,15,31);
        assertThat(nums)
                .hasSize(4)
                .contains(5,15)
                .allMatch(x->x>2)
                .allMatch(x-> x<50)
                .allMatch(x-> (x%2)!=0);
        assertThat("").isEmpty();
        assertThat("LMNP")
                .contains("MN")
                .startsWith("LM")
                .endsWith("NP");
//        assertThat(nums,hasSize(4));
//        assertThat(nums,hasItems(5,15));
//        assertThat(nums,everyItem(greaterThan(2)));
//        assertThat(nums,everyItem(lessThan(50)));
//        assertThat("",isEmptyString());
//        assertThat("LMNP",containsString("MN"));
//        assertThat("PQRS",startsWith("PQ"));
//        assertThat("XYZW",endsWith("ZW"));
    }
}
