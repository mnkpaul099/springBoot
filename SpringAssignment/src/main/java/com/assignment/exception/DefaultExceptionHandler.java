package com.assignment.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler
{
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler({ OrderNotFoundException.class })
    public final ResponseEntity<ErrorMessage> orderNotFound(final OrderNotFoundException ex) {
        final ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "OrderId not found.");
        return (ResponseEntity<ErrorMessage>)new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler({ CustomerNotFoundException.class })
    public final ResponseEntity<ErrorMessage> customerNotFound(final CustomerNotFoundException ex) {
        final ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "Customer not found.");
        return (ResponseEntity<ErrorMessage>)new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler({ ExistingOrderException.class })
    public final ResponseEntity<ErrorMessage> existingOrder(final ExistingOrderException ex) {
        final ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "OrderId already exist.");
        return (ResponseEntity<ErrorMessage>)new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}