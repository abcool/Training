package edu.learning.terminalOperations;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        System.out.println(" Collect names as List: ");
        StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::name, Collectors.toList())).forEach(System.out::println);
        System.out.println(" Collect activities as Set: ");
        StudentDatabase.getAllStudents()
                .stream()
                .map(Student::activities)
                .collect(Collectors.flatMapping(List::stream,Collectors.toSet())).forEach(System.out::println);
    }
}
