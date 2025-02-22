package edu.learning.numericStreams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class BoxingUnboxing {

    private static List<Integer> boxed(){
        return IntStream.rangeClosed(1,10)// int
                .boxed()// Integer
                .toList();
    }

    private static int[] unboxed(){
        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9,10);
        return integerList.stream()// Integer
                .mapToInt(Integer::intValue) // int
                .toArray();
    }

    public static void main(String[] args) {
        IntConsumer consumer = System.out::print;
        System.out.println(boxed());
        Arrays.stream(unboxed()).iterator().forEachRemaining(consumer);
    }
}
