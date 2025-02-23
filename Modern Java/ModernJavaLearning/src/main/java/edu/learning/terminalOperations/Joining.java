package edu.learning.terminalOperations;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.stream.Collectors;

public class Joining {
    private static String joining1(){
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::name)
                .collect(Collectors.joining());
    }
    private static String joining2(){
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::name)
                .collect(Collectors.joining("_"));
    }
    private static String joining3(){
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::name)
                .collect(Collectors.joining("_","[","]"));
    }
    public static void main(String[] args) {
        System.out.println("joining 1: "+ joining1());
        System.out.println("joining 2: "+ joining2());
        System.out.println("joining 3: "+ joining3());
    }
}
