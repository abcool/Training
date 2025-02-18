package edu.learning.methodReference;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.function.Consumer;

public class ConsumerMethodReference {
    // ClassName::methodName
    static Consumer<Student> printStudent = System.out::println;
    // ClassName::instanceMethodName
    static Consumer<Student> printActivities = Student::printActivities;
    public static void main(String[] args) {
        StudentDatabase.getAllStudents().forEach(printStudent);
        StudentDatabase.getAllStudents().forEach(printActivities);
    }
}
