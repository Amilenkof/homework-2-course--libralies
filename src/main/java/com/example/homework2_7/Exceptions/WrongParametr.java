package com.example.homework2_7.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongParametr extends RuntimeException {
    public WrongParametr(String message) {
        super(message);
    }
}
