package edu.learning.email_scheduler.api;

import edu.learning.email_scheduler.payload.EmailRequest;
import edu.learning.email_scheduler.payload.EmailResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ScheduleEmailAPI {

    @PostMapping("/schedule/email")
    public ResponseEntity<EmailResponse> scheduleEmail(@Valid @RequestBody EmailRequest emailRequest);
}
