package edu.learning.email_scheduler.qartz.job;

import edu.learning.email_scheduler.payload.EmailRequest;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
@Component
public class QuartzBuilder {

    public JobDetail buildJobDetail(EmailRequest emailRequest){
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("email", emailRequest.email());
        jobDataMap.put("subject", emailRequest.subject());
        jobDataMap.put("body", emailRequest.body());
        return JobBuilder.newJob(EmailJob.class)
                .withIdentity(UUID.randomUUID().toString(),"email-jobs")
                .withDescription("Send email job")
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    public Trigger buildTrigger(JobDetail jobDetail, ZonedDateTime startAt){
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(),"email-triggers")
                .withDescription("Send Email Trigger")
                .startAt(Date.from(startAt.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }

}
