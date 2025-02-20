package edu.learning.streams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

    public static void main(String[] args) {
        List<String> activities = StudentDatabase.getAllStudents()
                .stream()
                        .map(Student::activities)
                                .flatMap(List::stream)
                                        .collect(Collectors.toList());
        System.out.println(activities);
    }
}
