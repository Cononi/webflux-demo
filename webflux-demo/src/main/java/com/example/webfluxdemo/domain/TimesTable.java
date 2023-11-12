package com.example.webfluxdemo.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
public record TimesTable(
        LocalDateTime date,
        int output
) {

    public static TimesTable timesTableMap(int input){
        return TimesTable.builder()
                .date(LocalDateTime.now())
                .output(input * input)
                .build();
    }
}
