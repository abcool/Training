package edu.learning.email_scheduler.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public record EmailResponse(boolean success, String jobId, String jobGroup, String message, @JsonIgnore HttpStatus status) {
    public EmailResponse(boolean success, String message, HttpStatus status) {
        this(success, "", "", message, status);
    }
}
