package edu.learning.streams;

import java.util.List;
import java.util.Optional;

public class MinMax {
    // this will return value even if input is null
    public static int getMax(List<Integer> nums){
        return nums.stream().reduce(Integer.MIN_VALUE,(num1,num2)-> num1>num2?num1:num2);
    }
    // fixed version here
    public static Optional<Integer> getMaxValue(List<Integer> nums){
        return nums.stream().reduce((num1,num2)-> num1>num2?num1:num2);
    }

    public static Optional<Integer> getMinValue(List<Integer> nums){
        return nums.stream().reduce((num1,num2)-> num1<num2?num1:num2);
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(6,7,8,9,10);
        System.out.println(getMax(numbers));
        System.out.println(" Handled null value ");
        System.out.println(getMaxValue(numbers).get());
        System.out.println(" Getting min value: ");
        System.out.println(getMinValue(numbers).get());
    }
}
