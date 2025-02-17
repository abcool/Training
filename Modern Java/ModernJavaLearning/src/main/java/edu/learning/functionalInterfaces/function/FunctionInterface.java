package edu.learning.functionalInterfaces.function;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;
import edu.learning.functionalInterfaces.predicate.PredicateInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionInterface {
    private static Function<String,String> toUpper = name -> name.toUpperCase();

    private static Function<String,String> addSomeString = name -> name.concat(" |->end");

    private static Function<List<Student>, Map<String,Double>> studentNameAndGrade = students -> {
        Map<String,Double> nameGradeMap = new HashMap<>();
        students.forEach(student -> {
            if(PredicateInterface.filterByGPA.test(student))
            nameGradeMap.put(student.name(),student.gpa());
        });
        return nameGradeMap;
    };

    public static void main(String[] args) {
     //   System.out.println(toUpper.apply("hello World"));
     //   System.out.println(addSomeString.apply("hello world"));
//        System.out.println(toUpper.andThen(addSomeString).apply("hello World"));
//        System.out.println("Compose example: "+toUpper.compose(addSomeString).apply("hello World"));
        System.out.println("Printing student names with grade: "+ studentNameAndGrade.apply(StudentDatabase.getAllStudents()));
    }
}
