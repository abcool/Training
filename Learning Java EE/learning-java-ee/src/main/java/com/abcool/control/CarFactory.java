package com.abcool.control;

import com.abcool.entity.Car;
import com.abcool.entity.Specification;

import java.util.UUID;

public class CarFactory {

    public Car createCar(Specification specification) {
        Car car = new Car();
        car.setColor(specification.getColor());
        car.setEngineType(specification.getEngineType());
        car.setIdentifier(UUID.randomUUID().toString());
        return car;
    }
}