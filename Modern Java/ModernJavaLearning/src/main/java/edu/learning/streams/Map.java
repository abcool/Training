package edu.learning.streams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Map {
    static Function<Student,String> getNames = student -> student.name();
    public static void main(String[] args) {
        System.out.println(StudentDatabase.getAllStudents()
                .stream()
                .map(getNames)
                .collect(Collectors.toList()));
        System.out.println(StudentDatabase.getAllStudents()
                .stream()
                .map(Student::name)
                .map(String::toUpperCase)
                .collect(Collectors.toSet()));
    }
}
