package edu.learning.streams;

import java.util.Arrays;
import java.util.List;

public class LimitSkip {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6,7,8,9,10);

        System.out.println("Addition with limit 3: " +numbers.stream().limit(3).reduce((num1,num2)->num1+num2).get());
        System.out.println("Addition with skip 3: " +numbers.stream().skip(3).reduce((num1,num2)->num1+num2).get());
    }
}
