package com.itech.kinopoisk.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value(value = "${data.exception.noSuchElementMessage:No such element }")
    private String noSuchElementMessage;

    @Value(value = "${data.exception.JWTInvalidTokenMessage:Your authentication is invalid.}")
    private String JWTInvalidTokenMessage;

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<String> NoSuchElement(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>(noSuchElementMessage + noSuchElementException.getString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = JwtAuthenticationException.class)
    public ResponseEntity<String> JWTInvalidToken(JwtAuthenticationException jwtAuthenticationException) {
        return new ResponseEntity<>(JWTInvalidTokenMessage, HttpStatus.GONE);
    }

    @ExceptionHandler(value = TooLowAccessException.class)
    public ResponseEntity<String> NoSuchElement(TooLowAccessException tooLowAccessException) {
        return new ResponseEntity<>(tooLowAccessException.getString(), HttpStatus.BAD_REQUEST);
    }
}
