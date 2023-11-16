package com.example.webfluxdemo.common;

import lombok.Builder;

@Builder
public record ErrorResponse <T>(
        int code,
        String message,
        T data
) {

}
