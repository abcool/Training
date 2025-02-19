package edu.learning.lambdaVariables;

import java.util.function.Consumer;

public class LambdaVariable {
    private static int value = 0;
    public static void main(String[] args) {
        int i=0;
        // Not allowed to modify local variable.
       // Consumer<Integer> consumer = i -> System.out.println(i++);
        // cannot use same variable in lambda name as one defined as local variable
        // Consumer<Integer> consumer = i -> System.out.println(i);

        Consumer<Integer> consumer = i2 ->{
            // not allowed as i is already defined
           // int i=3;
            System.out.println(i2);
        };
        // This is allowed as value is an instance variable.
        Consumer<Integer> consumer1 = i1 -> System.out.println(value++);
    }
}
