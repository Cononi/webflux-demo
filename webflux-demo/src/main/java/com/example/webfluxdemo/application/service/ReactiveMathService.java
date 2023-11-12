package com.example.webfluxdemo.application.service;

import com.example.webfluxdemo.application.port.in.ReactiveMathUseCase;
import com.example.webfluxdemo.common.SleepUtil;
import com.example.webfluxdemo.domain.TimesTable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ReactiveMathService implements ReactiveMathUseCase {

    @Override
    public Mono<TimesTable> findSqaure(int input) {
        return Mono.fromSupplier(() -> input * input)
                .map(TimesTable::timesTableMap);
    }

    @Override
    public Flux<TimesTable> multiplicationTable(int input) {
        return Flux.range(1, 10)
                .doOnNext(i -> SleepUtil.sleepSeconds(1))
                .doOnNext(i -> System.out.println("reactive-math-service processing : " + i))
                .map(TimesTable::timesTableMap);
    }
}
