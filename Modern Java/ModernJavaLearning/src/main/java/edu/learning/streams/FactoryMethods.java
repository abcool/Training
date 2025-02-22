package edu.learning.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FactoryMethods {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("value1","value2","value3");
        System.out.println("Printing Stream.of result: ");
        stringStream.forEach(System.out::println);
        System.out.println(" Printing Stream.iterate output: ");
        Stream.iterate(1,x-> x+1).limit(10).forEach(System.out::println);
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        System.out.println("Printing Stream.generate output: ");
        Stream.generate(integerSupplier).limit(10).forEach(System.out::println);
    }
}
