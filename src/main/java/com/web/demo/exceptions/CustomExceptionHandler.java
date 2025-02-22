package com.web.demo.exceptions;

import com.web.demo.services.DatabaseUtilService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final DatabaseUtilService databaseUtilService;

    public CustomExceptionHandler(DatabaseUtilService databaseUtilService) {
        this.databaseUtilService = databaseUtilService;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /*@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Duplicate entry: " + ex.getRootCause().getMessage());
    }*/

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Throwable cause = ex.getCause(); // Get the underlying cause

        while (cause != null) { // Loop through wrapped exceptions
            if (cause instanceof ConstraintViolationException constraintEx) {
                SQLException sqlException = constraintEx.getSQLException();
                return handleSQLException(sqlException);
            }
            cause = cause.getCause(); // Move to next cause
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Data integrity violation: " + ex.getMessage());
    }

    private ResponseEntity<String> handleSQLException(SQLException sqlException) {
        String message = sqlException.getMessage();

        if (message.contains("unique constraint")) {
            String constraintName = extractConstraintName(message);
            if (constraintName.contains(".")) {
                constraintName = constraintName.split("\\.")[1];
            }
            List<String> columnNames = databaseUtilService.getColumnNamesForConstraint(constraintName);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Duplicate entry detected in column(s): " + columnNames);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Database error: " + message);
    }

    private String extractConstraintName(String errorMessage) {
        int start = errorMessage.indexOf("(");
        int end = errorMessage.indexOf(")", start);
        if (start != -1 && end != -1) {
            return errorMessage.substring(start + 1, end);
        }
        return "Unknown constraint";
    }
}

