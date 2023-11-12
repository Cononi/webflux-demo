package com.example.webfluxdemo.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public record TimesTable(
        LocalDateTime date,
        int output
) {
}
