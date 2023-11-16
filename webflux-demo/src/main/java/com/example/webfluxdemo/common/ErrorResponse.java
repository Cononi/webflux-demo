package com.example.webfluxdemo.common;

public record ErrorResponse(
        int errorCode,
        int input,
        String message
) {
}
