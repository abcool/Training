package edu.learning.sealedClasses;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    void vehicleTest(){
        var truck = new Truck();
        var bike = new Bike();
        var cycle = new Cycle();
        var dog = new Dog();
        var motorbike = new Motorcycle();
        assertInstanceOf(Vehicle.class,truck);
        assertInstanceOf(Vehicle.class,bike);
        assertInstanceOf(Bike.class,cycle);
        assertInstanceOf(Vehicle.class,cycle);
        assertInstanceOf(Bike.class,motorbike);
        assertInstanceOf(Truck.class,dog);// using non-sealed
//        assertInstanceOf(Vehicle.class,Dog.class);
    }

}