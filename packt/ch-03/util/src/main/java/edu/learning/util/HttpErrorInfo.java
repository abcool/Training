package edu.learning.util;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

public record HttpErrorInfo(ZonedDateTime timestamp, String path, HttpStatus httpStatus, String message){
    public HttpErrorInfo(){
        this(ZonedDateTime.now(), null , null, "");
    }
    public HttpErrorInfo(HttpStatus httpStatus, String path, String message) {
        this(ZonedDateTime.now(),path,httpStatus,message);
    }
};