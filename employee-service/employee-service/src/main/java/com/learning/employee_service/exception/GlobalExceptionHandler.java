package com.learning.employee_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorDetail> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException,
                                                                       WebRequest webRequest) {
        return new ResponseEntity<ErrorDetail>(new ErrorDetail(LocalDateTime.now(),
                employeeNotFoundException.getMessage(),
                webRequest.getDescription(false)), HttpStatus.NOT_FOUND);
    }
}
