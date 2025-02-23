package edu.learning.terminalOperations;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinByMaxBy {
    public static void main(String[] args) {
        Optional<Student> minGPAStudent = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::gpa)));
        System.out.println("minGPAStudent: "+ (minGPAStudent.isPresent()?minGPAStudent.get():Optional.empty()));
        Optional<Student> maxGpaStudent = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::gpa)));
        System.out.println("maxGpaStudent: "+ (maxGpaStudent.isPresent()?maxGpaStudent.get():Optional.empty()));
    }
}
