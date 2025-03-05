package edu.learning.sealedClasses;

public sealed class Bike extends Vehicle permits Motorcycle, Cycle{
    @Override
    public String toDo() {
        return "";
    }
}
