package edu.learning.functionalInterfaces.predicate;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BiPredicateInterface {

    BiPredicate<Integer,Double> biPredicate = (gradeLevel,Gpa) -> gradeLevel>=3 && Gpa>=3.5;

    BiConsumer<String, List<String>> nameAndActivities = (name,activities) -> System.out.println(name +" : "+activities);

    Consumer<Student> studentConsumer = student -> {
        if(biPredicate.test(student.gradelevel(),student.gpa())){
            nameAndActivities.accept(student.name(),student.activities());
        }
    };

    private void printNameAndActivities(){
        StudentDatabase.getAllStudents().forEach(studentConsumer);
    }
    public static void main(String[] args) {
        new BiPredicateInterface().printNameAndActivities();
    }
}
