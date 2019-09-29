package com.sb.rest.app.sbapph2.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

 /*   @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails("Validation Failed","101",new Date(),ex.getBindingResult().toString());
        System.out.println(" Error Details : "+errorDetails);
        //return new ResponseEntity(errorDetails.getStatuscode(), HttpStatus.BAD_REQUEST);

        return  new ResponseEntity(errorDetails.getStatuscode(),new HttpHeaders(),HttpStatus.EXPECTATION_FAILED);

    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest web){
        String errMsg=ex.getLocalizedMessage();
                ErrorDetails errorDetails=new ErrorDetails("Validation Failed","101",new Date(),errMsg);
        System.out.println(" Error Details : "+errorDetails);
        return new ResponseEntity<>(errorDetails.getStatuscode(),new HttpHeaders(),HttpStatus.EXPECTATION_FAILED);
    }*/
}
