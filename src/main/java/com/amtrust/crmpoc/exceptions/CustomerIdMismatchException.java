package com.amtrust.crmpoc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerIdMismatchException extends RuntimeException{

    public CustomerIdMismatchException(String exception) {
        super(exception);
    }
}
