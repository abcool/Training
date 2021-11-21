package com.abcool.control;

import com.abcool.entity.Car;
import com.abcool.entity.Color;
import com.abcool.entity.Specification;
import com.abcool.utils.Electric;

import javax.inject.Inject;
import java.util.UUID;

public class CarFactory {

    @Inject
    @Electric
    Color defaultCarColor;

    public Car createCar(Specification specification) {
        Car car = new Car();
        car.setColor(specification.getColor()==null? defaultCarColor:specification.getColor());
        car.setEngineType(specification.getEngineType());
        car.setIdentifier(UUID.randomUUID().toString());
        return car;
    }
}