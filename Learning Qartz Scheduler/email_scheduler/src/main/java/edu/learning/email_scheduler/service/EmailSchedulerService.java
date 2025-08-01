package edu.learning.email_scheduler.service;

import edu.learning.email_scheduler.payload.EmailRequest;
import edu.learning.email_scheduler.payload.EmailResponse;
import edu.learning.email_scheduler.qartz.job.QuartzBuilder;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class EmailSchedulerService {

    private static final Logger Log = LogManager.getLogger(EmailSchedulerService.class);

    private QuartzBuilder quartzBuilder;
    private Scheduler scheduler;

    @Autowired
    public EmailSchedulerService(QuartzBuilder quartzBuilder, Scheduler scheduler) {
        this.quartzBuilder = quartzBuilder;
        this.scheduler = scheduler;
    }

    public EmailResponse scheduleEmail(EmailRequest emailRequest) {
        try{
            ZonedDateTime dateTime = ZonedDateTime.of(emailRequest.dateTime(), emailRequest.timeZone());
            JobDetail jobDetail = quartzBuilder.buildJobDetail(emailRequest);
            Trigger trigger = quartzBuilder.buildTrigger(jobDetail, dateTime);
            scheduler.scheduleJob(jobDetail,trigger);

            return new EmailResponse(true,jobDetail.getKey().getName(),
                    jobDetail.getKey().getGroup(),"Email scheduled successfully.", HttpStatus.OK);
        } catch (SchedulerException ex) {
            Log.error("Error while scheduling email: {}", ex);
            EmailResponse emailResponse = new EmailResponse(false, "Error while scheduling email, please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
            return emailResponse;
        }
    }
}
