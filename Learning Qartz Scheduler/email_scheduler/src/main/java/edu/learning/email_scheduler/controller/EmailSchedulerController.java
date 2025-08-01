package edu.learning.email_scheduler.controller;

import edu.learning.email_scheduler.api.ScheduleEmailAPI;
import edu.learning.email_scheduler.payload.EmailRequest;
import edu.learning.email_scheduler.payload.EmailResponse;
import edu.learning.email_scheduler.qartz.job.QuartzBuilder;
import edu.learning.email_scheduler.service.EmailSchedulerService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class EmailSchedulerController implements ScheduleEmailAPI {
    private static final Logger Log = LogManager.getLogger(EmailSchedulerController.class);

    private EmailSchedulerService emailSchedulerService;
    @Autowired
    public EmailSchedulerController(EmailSchedulerService emailSchedulerService) {
        this.emailSchedulerService = emailSchedulerService;
    }

    @Override
    public ResponseEntity<EmailResponse> scheduleEmail(EmailRequest emailRequest) {
        EmailResponse response = emailSchedulerService.scheduleEmail(emailRequest);
        return ResponseEntity.status(response.status()).body(response);
    }
}
