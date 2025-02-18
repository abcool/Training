package edu.learning.constructorReference;

import edu.learning.data.Student;

import java.util.function.Function;

public class ConstructorMethodReference {
    static Function<String, Student> getStudent = Student::new;
    public static void main(String[] args) {
        System.out.println(getStudent.apply("Rahul"));
    }
}
