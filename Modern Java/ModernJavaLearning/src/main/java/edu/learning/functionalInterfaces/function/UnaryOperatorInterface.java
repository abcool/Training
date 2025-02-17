package edu.learning.functionalInterfaces.function;

import java.util.function.UnaryOperator;

public class UnaryOperatorInterface {
    public static UnaryOperator<String> concat = str1 -> str1.concat("|->end");
    public static void main(String[] args) {
        System.out.println(concat.apply("Hello World "));
    }
}
