package edu.learning.patternMatching;

public class PatternMatchingExample {
    public String matchPattern(Object o){
        return switch (o){
            case Integer i -> "Integer: "+i;
            case String s -> "String s of length: "+ s.length();
            case null, default -> "Not a string or integer";
        };
    }

    // record pattern
    public static String retrieveName(Animal animal){
        return switch(animal){
            case Dog(var name, var color) ->name;
            case Cat(String name, String color) -> name;
            case null, default -> "";
        };
    }

    // guarded pattern
    public static String retrieveNameGP(Animal animal){
        return switch(animal){
            case Dog(var name, var color) when name==null || name.isBlank() || name.isEmpty()-> "name absent";
            case Dog(var name, var color) -> name;
            case Cat(String name, String color) -> name;
            case null, default -> "";
        };
    }
    public static void main(String[] args) {
        PatternMatchingExample example = new PatternMatchingExample();
        System.out.println(example.matchPattern("Hello World"));
        Animal cat = new Cat("Vennie","White");
        Animal dog = new Dog("Rocky","Black");
        Animal teddyBear = new Dog("","White");
        System.out.println(retrieveName(cat));
        System.out.println(retrieveName(dog));
        System.out.println("Guarded pattern output: ");
        System.out.println(retrieveNameGP(cat));
        System.out.println(retrieveNameGP(dog));
        System.out.println(retrieveNameGP(teddyBear));
    }
}
