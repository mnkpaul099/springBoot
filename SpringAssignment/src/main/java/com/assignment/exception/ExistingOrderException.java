package com.assignment.exception;

public class ExistingOrderException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    public ExistingOrderException(final String message) {
        super(message);
    }
}