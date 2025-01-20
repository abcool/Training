package edu.learning.functionalInterfaces.consumer;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerInterface {
    public static void main(String[] args) {
        BiConsumer<String,String> biConsumer = (str1,str2)-> System.out.println("First String: "+ str1+" "+ " Second String: "+str2);
        //biConsumer.accept("Hello","World");
        BiConsumer<Integer,Integer> mulBiConsumer = (x,y)-> System.out.println("x*y: "+ x*y);
        //mulBiConsumer.accept(2,3);
        BiConsumer<Integer,Integer> divBiConsumer = (x,y)-> System.out.println("x/y: "+ (x/y));
       // mulBiConsumer.andThen(divBiConsumer).accept(4,2);
        printNameAndActivities();
    }
    private static void printNameAndActivities(){
        List<Student> students = StudentDatabase.getAllStudents();
        BiConsumer<String,List<String>> nameAndActivitiesFilter = (name,activities)-> System.out.println(name+" : "+ activities);
        students.forEach(student -> nameAndActivitiesFilter.accept(student.name(),student.activities()));
    }
}
