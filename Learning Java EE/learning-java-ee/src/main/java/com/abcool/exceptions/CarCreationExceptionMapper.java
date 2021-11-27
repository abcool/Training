package com.abcool.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CarCreationExceptionMapper implements ExceptionMapper<CarCreationException> {

    @Override
    public Response toResponse(CarCreationException exception) {
        return Response.serverError()
                .header("->Car-Creation-Error<-", exception)
                .entity(exception.getMessage())
                .build();
    }
}
