package edu.learning.email_scheduler.payload;

import jakarta.validation.constraints.*;
import org.aspectj.lang.annotation.After;

import java.time.LocalDateTime;
import java.time.ZoneId;

public record EmailRequest(@Email @NotEmpty String email, @NotEmpty String subject,
                           @NotEmpty String body, @NotNull @FutureOrPresent(message = "Please mention a date in present or future") LocalDateTime dateTime,
                           @NotNull ZoneId timeZone) {}
