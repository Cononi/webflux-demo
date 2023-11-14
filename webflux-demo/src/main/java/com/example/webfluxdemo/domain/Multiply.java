package com.example.webfluxdemo.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
public record Multiply(
        int first,
        int second
) {
}
