package edu.learning.functionalInterfaces.function;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;
import edu.learning.functionalInterfaces.predicate.PredicateInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionInterface {

    public static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> studentGrade =
            (students, studentPredicate) -> {
                Map<String,Double> studentGradeMap = new HashMap<>();
                    students.forEach(student -> {
                        if(studentPredicate.test(student))
                            studentGradeMap.put(student.name(),student.gpa());
                    });
                    return studentGradeMap;
            };
    public static void main(String[] args) {
        System.out.println("Students filtered: "+ studentGrade.apply(StudentDatabase.getAllStudents(), PredicateInterface.filterByGrade));
    }
}
