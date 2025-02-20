package edu.learning.methodReference;

import edu.learning.data.Student;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RefactorForMethodReference {

    static Supplier<Student> getStudent = () -> new Student("John",2,3.6,"male", Arrays.asList("swimming","basketball","volleyball"),11);

    static Predicate<Student> checkGradeLevel = RefactorForMethodReference::validateGrade;

    private static boolean validateGrade(Student s){
        return s.gradelevel()>3;
    }

    public static void main(String[] args) {
        System.out.println(checkGradeLevel.test(getStudent.get()));
    }
}
