package edu.learning.optional;

import java.util.Optional;

public class OfOfNullable {
    private static Optional<String> ofNullable(){
        return Optional.ofNullable(" Hello World");
    }
    private static Optional<String> ofNullable_2(){
        return Optional.ofNullable(null);
    }
    private static Optional<String> of(){
        return Optional.of(" Welcome to Jungle.");
    }
    // This will throw null pointer exception as Optional.of accepts non null value only
    private static Optional<String> of_2(){
        return Optional.of(null);
    }
    private static Optional<String> empty(){
        return Optional.empty();
    }
    public static void main(String[] args) {
        System.out.println(ofNullable());
        System.out.println(ofNullable_2());
        System.out.println(of());
      //  System.out.println(of_2());
        System.out.println(empty());
    }
}
