package edu.learning.util.http;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
public record HttpErrorDTO(ZonedDateTime timestamp, String path, HttpStatus httpStatus, String message){
    public HttpErrorDTO(HttpStatus httpStatus, String path, String message) {
        this(ZonedDateTime.now(), path, httpStatus, message);
    }
}