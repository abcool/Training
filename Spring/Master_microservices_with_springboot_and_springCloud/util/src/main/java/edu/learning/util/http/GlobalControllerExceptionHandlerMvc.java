package edu.learning.util.http;

import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import jakarta.servlet.http.HttpServletRequest;

import java.time.ZonedDateTime;

@ControllerAdvice
@ConditionalOnClass(HttpServletRequest.class)
public class GlobalControllerExceptionHandlerMvc {

    private static final Logger log = LogManager.getLogger(GlobalControllerExceptionHandlerMvc.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpErrorInfo handleNotFoundException(HttpServletRequest request, NotFoundException ex) {
        return createHttpErrroInfo(HttpStatus.NOT_FOUND, request, ex);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidInputException.class)
    public @ResponseBody HttpErrorInfo handleInvalidInputException(HttpServletRequest request, InvalidInputException ex) {
        return createHttpErrroInfo(HttpStatus.UNPROCESSABLE_ENTITY, request, ex);
    }

    private HttpErrorInfo createHttpErrroInfo(HttpStatus status, HttpServletRequest request, Exception ex) {
        final String path = request.getRequestURI();
        final String message = (ex.getMessage()==null || ex.getMessage().isBlank()) ? status.getReasonPhrase() : ex.getMessage();
        log.debug("Returning HTTP status: {} for path: {}, message: {}", status, path, message);
        return new HttpErrorInfo(ZonedDateTime.now(), path, status, message);
    }
}