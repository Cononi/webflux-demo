package com.example.webfluxdemo.common.exception;


import com.example.webfluxdemo.common.ResponseCode;
import lombok.Getter;

@Getter
public class InputValidException extends RuntimeException {

    private final ResponseCode responseCode;
    private final int input;
    public InputValidException(ResponseCode responseCode, int input) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
        this.input = input;
    }
}
