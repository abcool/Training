package edu.learning.functionalInterfaces;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerAndPredicate {
    private final Predicate<Student> checkGradeLevel = student -> student.gradelevel()>=3;
    private final Predicate<Student> checkGpa = student -> student.gpa()>=3.9;

    private final BiConsumer<String, List<String>> nameAndActivities = (name,activities) -> System.out.println(name +" : "+activities);

    private final Consumer<Student> studentBiConsumer = student ->{
        if(checkGradeLevel.and(checkGpa).test(student))
            nameAndActivities.accept(student.name(),student.activities());
    };
    private void printNameAndActivities(List<Student> studentList){
      //  studentList.forEach(student -> studentBiConsumer.accept(student));
        studentList.forEach(studentBiConsumer);
    }
    public static void main(String[] args) {
        new ConsumerAndPredicate().printNameAndActivities(StudentDatabase.getAllStudents());
    }
}
