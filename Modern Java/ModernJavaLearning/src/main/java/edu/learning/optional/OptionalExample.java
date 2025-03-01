package edu.learning.optional;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;
import edu.learning.functionalInterfaces.supplier.SupplierInterface;

import java.util.Optional;

public class OptionalExample {

    private static Optional<String> studentName(){
        Optional<Student> student = Optional.ofNullable(SupplierInterface.getStudent.get());
        Optional<Student> student2 = Optional.ofNullable(null);
        if(student.isPresent()){
            return student.map(Student::name);
        }
        if(student2.isPresent())
            return student2.map(Student::name);

        return Optional.empty();
    }
    public static void main(String[] args) {
        System.out.println(studentName());
    }
}
