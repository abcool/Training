package edu.learning.functionalInterfaces.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorInterface {
    public static BinaryOperator<Integer> calculate = (a,b) -> a*a + b*b + 2*a*b;

    static Comparator<Integer> logic = (a,b) -> a.compareTo(b);

    public static BinaryOperator<Integer> maxNum = BinaryOperator.maxBy(logic);

    public static BinaryOperator<Integer> minMum = BinaryOperator.minBy(logic);
    public static void main(String[] args) {
        System.out.println("Ans: "+calculate.apply(2,3));
        System.out.println(" Max of a and b: "+ maxNum.apply(3,4));
        System.out.println(" Min of a and b: "+ minMum.apply(3,4));
        System.out.println("Inline: "+ BinaryOperator.maxBy((Integer a,Integer b) -> a.compareTo(b)).apply(5,6));
    }
}
