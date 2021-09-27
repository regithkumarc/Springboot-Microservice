package com.cprm.userservice.exception;

import javassist.NotFoundException;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){

        ErrorMessage errorMessage = new ErrorMessage(301,ex.toString(),new Date());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //return this.handleExceptionInternal(ex, (Object)null, headers, status, request);
        ErrorMessage errorMessage = new ErrorMessage(status.value(),ex.toString(),new Date());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request){

        ErrorMessage errorMessage = new ErrorMessage(204,ex.toString(),new Date());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


}
