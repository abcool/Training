package com.abcool.boundary;

import com.abcool.entity.Car;
import com.abcool.entity.Specification;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("cars")
public class CarResource {

    @Inject
    CarManufacturer carManufacturer;

    @Context
    UriInfo uriInfo;

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
    public Response createCar(@Valid @NotNull Specification specification){
        Car car = carManufacturer.manufactureCar(specification);
        URI uri = uriInfo.getBaseUriBuilder()
                .path(CarResource.class)
                .path(CarResource.class,"retrieveCar")
                .build(car.getIdentifier());
        return Response.created(uri)
                .entity(car)
                .build();
    }
    @GET
    @Path("{id}")
    public Car retrieveCar(@PathParam("id") String id){
        return carManufacturer.retrieveCar(id);
    }
}
