package edu.learning.terminalOperations;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitioningBy {
    private  static final Predicate<Student> gpaCheck = student -> student.gpa()>3.9;

    private static Map<Boolean, List<Student>> partitioningBy_1(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaCheck));
    }

    private static Map<Boolean, Set<Student>> partitioningBy_2(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaCheck,Collectors.toSet()));
    }

    public static void main(String[] args) {
      //  System.out.println(partitioningBy_1());
        System.out.println(partitioningBy_2());
    }
}
