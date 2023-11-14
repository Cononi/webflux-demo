package com.example.webfluxdemo.application.port.in;

import com.example.webfluxdemo.domain.Multiply;
import com.example.webfluxdemo.domain.TimesTable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveMathUseCase {

    Mono<TimesTable> findSqaure(int input);
    Flux<TimesTable> multiplicationTable(int input);
    Flux<TimesTable> asyncMultiplicationTable(int input);

    Mono<TimesTable> multiplyMono(Mono<Multiply> dtoMono);
}
