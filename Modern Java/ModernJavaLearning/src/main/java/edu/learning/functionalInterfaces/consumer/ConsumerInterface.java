package edu.learning.functionalInterfaces.consumer;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {

    private static final Consumer<Student> studentConsumerNames = (student) -> System.out.print(student.name());
    private static final Consumer<Student> studentConsumerActivities = (student) -> System.out.println(student.activities());
    public static void main(String[] args) {

        //ConsumerInterfaceImpl();
        //printStudents();
        //printNamesAndActivities();
        printNamesAndActivitiesAndFiltering();
    }
    private static void ConsumerInterfaceImpl(){
        Consumer<String> consumer = (input) -> System.out.println(input.toUpperCase());
        consumer.accept(" Hello World");
    }
    private static void printStudents(){
        Consumer<Student> studentConsumer = (student) -> System.out.println(student);
        List<Student> students = StudentDatabase.getAllStudents();
        students.forEach(studentConsumer);
    }
    private static void printNamesAndActivities(){

//        Consumer<Student> studentConsumerNames = (student) -> System.out.print(student.name());
//        Consumer<Student> studentConsumerActivities = (student) -> System.out.println(student.activities());
        // consumer chaining
        StudentDatabase.getAllStudents().forEach(studentConsumerNames.andThen(studentConsumerActivities));
    }

    private static void printNamesAndActivitiesAndFiltering(){
        StudentDatabase.getAllStudents().forEach(
                student -> {
                    if(student.gradelevel()>=3 && student.gpa()>=3.9){
                        studentConsumerNames.andThen(studentConsumerActivities).accept(student);
                    }
                }
                );
    }
}
