package com.example.webfluxdemo.common.handler;

import com.example.webfluxdemo.common.ErrorResponse;
import com.example.webfluxdemo.common.ResponseCode;
import com.example.webfluxdemo.common.exception.InputValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(InputValidException.class)
    public ResponseEntity<ErrorResponse> handleExcetip(InputValidException ex) {
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .code(ex.getResponseCode().getCode())
                .message(ex.getMessage())
                .data(ex.getData())
                .build());
    }
}
