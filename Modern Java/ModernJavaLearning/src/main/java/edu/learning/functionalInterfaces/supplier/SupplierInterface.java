package edu.learning.functionalInterfaces.supplier;

import edu.learning.data.Bike;
import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class SupplierInterface {
    public static final Supplier<Student> getStudent = () -> new Student("Rahul",11,4.5,"Male", List.of("Swimming"),12) ;
    private static final Optional<Bike> bike = Optional.ofNullable(new Bike("RX100","2002"));
    public static  final Supplier<Student> studentWithBike = () -> new Student("Ronit",6,3.9,"Male",List.of("Swimming","Long drive"),5,bike);
    public static Supplier<List<Student>> getStudents = () -> StudentDatabase.getAllStudents();
    public static void main(String[] args) {
        System.out.println(" Get Student: "+ getStudent.get());
        System.out.println(" Get all Students: " + getStudents.get());
    }
}
