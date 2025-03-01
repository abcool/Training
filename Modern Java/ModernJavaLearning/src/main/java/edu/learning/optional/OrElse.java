package edu.learning.optional;

import edu.learning.data.Student;
import edu.learning.functionalInterfaces.supplier.SupplierInterface;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OrElse {
    private static void orElse(){
        Optional<Student> student =Optional.ofNullable(SupplierInterface.getStudent.get());
        String name = student
                        .map(Student::name)
                                .orElse("Dummy Student");

        System.out.println(name);
    }
    private static void orElseGet(){
        Optional<Student> student =Optional.ofNullable(SupplierInterface.getStudent.get());
        String name = student
                .map(Student::name)
                .orElseGet(() -> "Dummy Student");

        System.out.println(name);
    }
    private static void orElseThrow(){
        Optional<Student> student =Optional.ofNullable(SupplierInterface.getStudent.get());
        String name = student
                .map(Student::name)
                .orElseThrow(() -> new NoSuchElementException(" Student not found "));

        System.out.println(name);
    }
    public static void main(String[] args) {
        orElse();
        orElseGet();
        orElseThrow();
    }
}
