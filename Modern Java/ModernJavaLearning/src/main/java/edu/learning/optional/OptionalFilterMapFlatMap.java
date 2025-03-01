package edu.learning.optional;

import edu.learning.data.Bike;
import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;
import edu.learning.functionalInterfaces.supplier.SupplierInterface;

import java.util.Optional;

public class OptionalFilterMapFlatMap {
    private static void filter(){
        Optional<Student> studentOptional = Optional.ofNullable(SupplierInterface.getStudent.get());
        studentOptional.filter(student -> student.gpa()>3.9)
                .ifPresent(System.out::println);
    }
    private static void map(){
        Optional<Student> studentOptional = Optional.ofNullable(SupplierInterface.getStudent.get());
        studentOptional
                .map(Student::name)
                .ifPresent(System.out::println);
    }
    private static void flatMap(){
        Optional<Student> studentOptional = Optional.ofNullable(SupplierInterface.studentWithBike.get());
        Optional<String> bikeName = studentOptional
                .flatMap(Student::bike)
                .map(Bike::name);
        System.out.println(bikeName);
    }
    public static void main(String[] args) {
        filter();
        map();
        flatMap();
    }
}
