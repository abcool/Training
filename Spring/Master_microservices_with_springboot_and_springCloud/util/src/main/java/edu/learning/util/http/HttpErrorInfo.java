package edu.learning.util.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
public class HttpErrorInfo {
    private final ZonedDateTime timestamp;
    private final String path;
    private final HttpStatus httpStatus;
    private final String message;

    @SuppressWarnings("unused")
    public HttpErrorInfo(){
        this.timestamp = ZonedDateTime.now();
        this.path="";
        this.httpStatus=HttpStatus.NOT_IMPLEMENTED;
        this.message="";
    }
}
