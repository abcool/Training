package edu.learning.methodReference;

import java.util.function.Function;

public class FunctionMethodReference {
    // ClassName::methodName
    static Function<String,String> toUpper = String::toUpperCase;
    public static void main(String[] args) {
        System.out.println(toUpper.apply("Hello World"));
    }
}
