package edu.learning.sealedClasses;

public sealed abstract class Vehicle permits Bike,Truck{
    public abstract String toDo();
}
