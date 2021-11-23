package com.abcool.boundary;

import com.abcool.entity.Car;
import com.abcool.entity.Specification;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("cars")
public class CarResource {

    @Inject
    CarManufacturer carManufacturer;

    @Path("allCars")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> allCars(){
      return carManufacturer.retrieveCars();
    }

    @Path("retrieveCars")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray retrieve(){
        return carManufacturer.retrieveCars()
                .stream()
                .map(c-> Json.createObjectBuilder()
                .add("color",c.getColor().name())
                .add("engineType",c.getEngineType().name())
                .build())
                .collect(JsonCollectors.toJsonArray());
    }

    @Path("createCar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car createCar(Specification specification){
        return carManufacturer.manufactureCar(specification);
    }
}
