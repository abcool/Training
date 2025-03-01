package edu.learning.optional;

import java.util.Optional;

public class ifPresentisPresent {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.ofNullable("Hello");
        System.out.println(stringOptional.isPresent());
        stringOptional.ifPresent(System.out::println);
    }
}
