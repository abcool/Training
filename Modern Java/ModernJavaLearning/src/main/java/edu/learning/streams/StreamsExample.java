package edu.learning.streams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    static Predicate<Student> GradeFilter = student -> student.gradelevel()>=3;
    static Predicate<Student> GpaFilter = student -> student.gpa() >=3.9;
    public static void main(String[] args) {
        Map<String, List<String>> studentMap =StudentDatabase.getAllStudents().stream()
                .filter(GradeFilter)
                .filter(GpaFilter)
                .collect(Collectors.toMap(Student::name,Student::activities));
        System.out.println(studentMap);
    }
}
