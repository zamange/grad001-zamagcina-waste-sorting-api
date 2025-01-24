package com.enviro.assessment.grad001.zamagcina_ngeyane.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler handles all exceptions globally within the application.
 * This class provides methods for handling validation errors and general exceptions.
 * It ensures that appropriate responses are returned to the client in case of errors.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException, which is thrown when validation fails for method arguments.
     * It collects all field errors from the exception and returns them in a response with a BAD_REQUEST status.
     *
     * @param ex The exception that contains the validation errors.
     * @return A ResponseEntity containing a map of field errors and a BAD_REQUEST status.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles general exceptions that may occur during the application execution.
     * It captures the exception message and returns it in the response with an INTERNAL_SERVER_ERROR status.
     *
     * @param ex The exception that was thrown during the application's execution.
     * @return A ResponseEntity containing the exception message and an INTERNAL_SERVER_ERROR status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
