package com.example.webfluxdemo.application.service;

import com.example.webfluxdemo.application.port.in.TimesTableUseCase;
import com.example.webfluxdemo.common.SleepUtil;
import com.example.webfluxdemo.domain.TimesTable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class TimesTableService implements TimesTableUseCase {

    @Override
    public TimesTable findSquare(int input) {
        return TimesTable.builder()
                .date(LocalDateTime.now())
                .output(input * input)
                .build();
    }

    @Override
    public List<TimesTable> multiplicationTable(int input) {
        return IntStream.rangeClosed(1, 10)
                .peek(i -> SleepUtil.sleepSeconds(1))
                .peek(i -> System.out.println("math service processing : " + i))
                .mapToObj(i -> TimesTable.builder()
                        .date(LocalDateTime.now())
                        .output(i*input)
                        .build()
                ).toList();
    }
}
