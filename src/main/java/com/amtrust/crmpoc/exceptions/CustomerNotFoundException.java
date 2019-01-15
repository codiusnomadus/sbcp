package com.amtrust.crmpoc.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
