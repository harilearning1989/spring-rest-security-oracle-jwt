package com.web.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(OutOfMemoryError.class)
    public ProblemDetail handleOOM(OutOfMemoryError e) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        detail.setTitle("Out of Memory");
        detail.setDetail("Server ran out of memory. Please try again later.");
        return detail;
    }
}

