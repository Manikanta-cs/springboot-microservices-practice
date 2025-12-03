package com.learning.department_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDetail> handleDepartmentNotFoundException(DepartmentNotFoundException departmentNotFoundException,
                                                                         WebRequest webRequest) {
        return new ResponseEntity<>(new ErrorDetail(
                LocalDateTime.now(),
                departmentNotFoundException.getMessage(),
                webRequest.getDescription(false)
        ), HttpStatus.NOT_FOUND);
    }
}
