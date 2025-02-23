package edu.learning.terminalOperations;

import edu.learning.data.StudentDatabase;

import java.util.stream.Collectors;

public class Counting {
    private static long count(){
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.gpa()>3.8)
                .collect(Collectors.counting());
    }
    public static void main(String[] args) {
        System.out.println(" Students with gpa > 3.8 are: "+ count());
    }
}
