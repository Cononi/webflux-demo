package com.example.webfluxdemo.application.service;

import com.example.webfluxdemo.application.port.in.ReactiveMathUseCase;
import com.example.webfluxdemo.common.SleepUtil;
import com.example.webfluxdemo.domain.TimesTable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ReactiveMathService implements ReactiveMathUseCase {

    @Override
    public Mono<TimesTable> findSqaure(int input) {
        return Mono.fromSupplier(() -> input)
                .map(TimesTable::timesTableMap);
    }

    @Override
    public Flux<TimesTable> multiplicationTable(int input) {
        return Flux.range(1, 10)
                .doOnNext(i -> SleepUtil.sleepSeconds(1))
                .doOnNext(i -> System.out.println("reactive-math-service processing : " + i))
                .map(TimesTable::timesTableMap);
    }

    // 더 효율적인 비동기 지연처리
    @Override
    public Flux<TimesTable> asyncMultiplicationTable(int input) {
        // 안좋은 코드 ------
//        List<TimesTable> list = IntStream.rangeClosed(1, 10)
//                .peek(i -> SleepUtil.sleepSeconds(1))
//                .peek(i -> System.out.println("math service processing : " + i))
//                .mapToObj(i -> TimesTable.builder()
//                        .date(LocalDateTime.now())
//                        .output(i*input)
//                        .build()
//                ).toList();
//        return Flux.fromIterable(list);
        // 안좋은 코드 end
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("reactive-math-service processing : " + i))
                .map(TimesTable::timesTableMap);
    }
}
