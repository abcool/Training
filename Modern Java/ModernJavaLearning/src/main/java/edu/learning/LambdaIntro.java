package edu.learning;

import java.util.Comparator;

public class LambdaIntro {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Testing runnable");
        new Thread(runnable).start();
        new Thread(()-> System.out.println("Message")).start();
        Comparator<String> myCompare = (str1, str2) -> str1.equals(str2)?0:-1;
        System.out.println(myCompare.compare("hello", "world"));
    }
}
