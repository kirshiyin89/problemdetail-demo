package com.problemdetail.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.ProblemDetail;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    ProblemDetail handleProductNotFoundException(ProductNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Product Not Found");
        problemDetail.setType(URI.create("https://myproduct.com/error"));
        problemDetail.setProperty("exception type", "This is a business exception");
        return problemDetail;
    }
}