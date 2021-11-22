package com.abcool.boundary;

import com.abcool.control.CarFactory;
import com.abcool.control.CarRepository;
import com.abcool.entity.Car;
import com.abcool.entity.EngineType;
import com.abcool.entity.Specification;
import com.abcool.events.CarCreated;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;
    @Inject
    CarRepository carRepository;

   /* @Inject
    Event<CarCreated> carCreatedEvent;*/

    public Car manufactureCar(Specification specification){
        Car car = carFactory.createCar(specification);
        carRepository.store(car);
        //carCreatedEvent.fire(new CarCreated(car.getIdentifier()));
        return car;
    }

    private Car createCar(Specification specification) {
        return carFactory.createCar(specification);
    }

    public List<Car> retrieveCars() {
        return carRepository.loadCars();
    }

    public List<Car> retrieveCars(EngineType filter) {
        return carRepository.loadCars().stream()
                .filter(c -> c.getEngineType() == filter)
                .collect(Collectors.toList());
    }

    public Car retrieveCar(String identifier) {
        Car car = new Car();
        car.setIdentifier(identifier);
        return car;
    }
}
