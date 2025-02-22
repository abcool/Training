package edu.learning.streams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.Optional;

public class Find {
    private static Optional<Student> findAny(){
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.gpa()>3.9)
                .findAny();
    }
    private static Optional<Student> findFirst(){
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.gpa()>3.9)
                .findFirst();
    }
    public static void main(String[] args) {
        System.out.println("Find any: "+ findAny());
        System.out.println(" Find first: "+ findFirst());
    }
}
