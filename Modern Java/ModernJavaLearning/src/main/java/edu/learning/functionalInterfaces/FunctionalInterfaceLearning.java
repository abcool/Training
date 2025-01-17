package edu.learning.functionalInterfaces;

import java.util.function.Consumer;

public class FunctionalInterfaceLearning {
    public static void main(String[] args) {
        ConsumerInterfaceImpl();
    }
    private static void ConsumerInterfaceImpl(){
        Consumer<String> consumer = (input) -> System.out.println(input.toUpperCase());
        consumer.accept(" Hello World");
    }
}
