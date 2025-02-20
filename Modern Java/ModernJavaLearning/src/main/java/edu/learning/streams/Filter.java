package edu.learning.streams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class Filter {
    static Predicate<Student> femaleStudents = student -> student.gender().equalsIgnoreCase("female");

    private static List<Student> getFemaleStudents(){
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(femaleStudents)
                .toList();
    }

    public static void main(String[] args) {
        System.out.println("Printing female students");
        getFemaleStudents().forEach(System.out::println);
    }
}
