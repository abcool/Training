package com.abcool.boundary;

import com.abcool.control.CarFactory;
import com.abcool.control.CarRepository;
import com.abcool.entity.Car;
import com.abcool.entity.Specification;

import javax.ejb.Stateless;
import javax.inject.Inject;
@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;
    @Inject
    CarRepository carRepository;

    public Car manufacturer(Specification specification){
        Car car = carFactory.createCar(specification);
        carRepository.store(car);
        return car;
    }

    private Car createCar(Specification specification) {
        return carFactory.createCar(specification);
    }
}
