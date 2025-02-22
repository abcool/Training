package edu.learning.numericStreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStream {
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1,6).sum());
        IntStream intStream = IntStream.range(1,50);
        intStream.forEach(System.out::println);
        System.out.println(LongStream.rangeClosed(1,50).count());
        IntStream.rangeClosed(1,50).asDoubleStream().forEach(System.out::println);
        int sum = IntStream.range(1,10).sum();
        int max = IntStream.rangeClosed(1,10).max().getAsInt();
        long min = LongStream.rangeClosed(1,10).min().getAsLong();
        double avg = LongStream.rangeClosed(1,50).asDoubleStream().average().getAsDouble();
    }
}
