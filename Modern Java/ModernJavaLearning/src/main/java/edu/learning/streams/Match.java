package edu.learning.streams;

import edu.learning.data.StudentDatabase;

public class Match {
    private static boolean allMatch(){
        return StudentDatabase.getAllStudents().stream().allMatch(student -> student.gpa()>3.9);
    }
    private static boolean anyMatch(){
        return StudentDatabase.getAllStudents().stream().anyMatch(student -> student.gpa()>3.9);
    }
    private static boolean nonMatch(){
        return StudentDatabase.getAllStudents().stream().noneMatch(student -> student.gpa()>4.0);
    }
    public static void main(String[] args) {
        System.out.println(allMatch());
        System.out.println(anyMatch());
        System.out.println(nonMatch());
    }
}
