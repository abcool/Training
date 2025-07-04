package edu.learning.util.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpErrorDTO handleNotFoundExceptions(
            ServerHttpRequest request, NotFoundException ex) {

        return createHttpErrorDTO(NOT_FOUND, request, ex);
    }

    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidInputException.class)
    public @ResponseBody HttpErrorDTO handleInvalidInputException(
            ServerHttpRequest request, InvalidInputException ex) {

        return createHttpErrorDTO(UNPROCESSABLE_ENTITY, request, ex);
    }
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody HttpErrorDTO handleBadRequestException(
            ServerHttpRequest request, RuntimeException ex) {

        return createHttpErrorDTO(BAD_REQUEST, request, ex);
    }

    private HttpErrorDTO createHttpErrorDTO(
            HttpStatus httpStatus, ServerHttpRequest request, Exception ex) {

        final String path = request.getPath().pathWithinApplication().value();
        final String message = ex.getMessage();


        LOG.debug("Returning HTTP status: {} for path: {}, message: {}", httpStatus, path, message);
        return new HttpErrorDTO(httpStatus, path, message);
    }
}