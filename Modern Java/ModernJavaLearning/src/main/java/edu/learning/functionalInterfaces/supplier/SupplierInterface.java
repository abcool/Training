package edu.learning.functionalInterfaces.supplier;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.function.Supplier;

public class SupplierInterface {
    public static Supplier<Student> getStudent = () -> new Student("Rahul",11,4.5,"Male", List.of("Swimming")) ;
    public static Supplier<List<Student>> getStudents = () -> StudentDatabase.getAllStudents();
    public static void main(String[] args) {
        System.out.println(" Get Student: "+ getStudent.get());
        System.out.println(" Get all Students: " + getStudents.get());
    }
}
