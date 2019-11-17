package com.payconiq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StockIdNotFoundException extends RuntimeException {
    public StockIdNotFoundException(String message) {
        super(message);
    }
}
