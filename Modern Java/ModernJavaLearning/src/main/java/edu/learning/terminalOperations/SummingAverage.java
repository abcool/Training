package edu.learning.terminalOperations;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class SummingAverage {

    private static int totalNotebooks(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::notebooks));
    }

    private static double averageNotebooks(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::notebooks));
    }
    private static double summingDouble(){
        return IntStream.rangeClosed(1,50)
                .asDoubleStream()
                .boxed()
                .collect(Collectors.summingDouble(Double::doubleValue));
    }
    private static double averagingDouble(){
        return IntStream.rangeClosed(1,50)
                .asDoubleStream()
                .boxed()
                .collect(Collectors.averagingDouble(Double::doubleValue));
    }
    public static void main(String[] args) {
        System.out.println(" Printing total notebooks: ");
        System.out.println(totalNotebooks());
        System.out.println(" Printing average notebooks: ");
        System.out.println(averageNotebooks());
        System.out.println(" Printing summingDouble: ");
        System.out.println(summingDouble());
        System.out.println(" Printing averagingDouble: ");
        System.out.println(averagingDouble());
    }
}
