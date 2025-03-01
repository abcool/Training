package edu.learning.interfaceMethods;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;
import edu.learning.functionalInterfaces.supplier.SupplierInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NullsFirstNullsLast {
    private static void nullFirstSort(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(SupplierInterface.getStudent.get());
        studentList.add(SupplierInterface.studentWithBike.get());
        studentList.add(null);
        Comparator<Student> nameComparator = Comparator.nullsFirst(Comparator.comparing(Student::name));
        studentList.sort(nameComparator);
        studentList.forEach(System.out::println);
    }
    private static void nullLastSort(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(SupplierInterface.getStudent.get());
        studentList.add(SupplierInterface.studentWithBike.get());
        studentList.add(null);
        Comparator<Student> nameComparator = Comparator.nullsLast(Comparator.comparing(Student::name));
        studentList.sort(nameComparator);
        studentList.forEach(System.out::println);
    }
    public static void main(String[] args) {
        nullFirstSort();
        System.out.println("Nulls last: ");
        nullLastSort();
    }
}
