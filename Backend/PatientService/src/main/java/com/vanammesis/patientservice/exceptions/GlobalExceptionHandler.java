package com.vanammesis.patientservice.exceptions;


import com.vanammesis.patientservice.controller.PatientController;
import com.vanammesis.patientservice.responses.ExceptionResponse;
import io.jsonwebtoken.JwtException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice(basePackageClasses = PatientController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionResponse notFoundHandler(ResourceNotFoundException foundException){
        return ExceptionResponse.builder().message(Arrays.toString(foundException.getStackTrace()))
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse validationFailed(MethodArgumentNotValidException methodArgumentNotValidException){

        return ExceptionResponse.builder().message(methodArgumentNotValidException.getMessage())
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }

    @ExceptionHandler(JwtException.class)
    public ExceptionResponse expiredJwtToken(JwtException jwtException){
        return ExceptionResponse.builder().message(jwtException.getMessage())
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionResponse constratintVolation(ConstraintViolationException constraintViolationException){
        return ExceptionResponse.builder().message(constraintViolationException.getMessage())
                .status(HttpStatus.NOT_FOUND).success(false).build();
    }

}
