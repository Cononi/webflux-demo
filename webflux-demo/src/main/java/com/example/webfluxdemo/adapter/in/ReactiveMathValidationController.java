package com.example.webfluxdemo.adapter.in;

import com.example.webfluxdemo.application.port.in.ReactiveMathUseCase;
import com.example.webfluxdemo.common.ResponseCode;
import com.example.webfluxdemo.common.exception.InputValidException;
import com.example.webfluxdemo.domain.TimesTable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
@RequiredArgsConstructor
public class ReactiveMathValidationController {
    private final ReactiveMathUseCase reactiveMathUseCase;

    @GetMapping("square/{input}/throw")
    public Mono<TimesTable> findSquare(@PathVariable int input){
        if(input < 10 || input > 20)
            throw new InputValidException(ResponseCode.FAIL_100, input);
        return this.reactiveMathUseCase.findSqaure(input);
    }

    @GetMapping("square/{input}/mono-error")
    public Mono<TimesTable> monoError(@PathVariable int input){
        return Mono.just(input)
                .handle((integer, sink) -> {
                    if(integer >= 10 && integer <= 20)
                        sink.next(integer);
                    else
                        sink.error(new InputValidException(ResponseCode.FAIL_100, input));
                })
                .cast(Integer.class) // 정수로 변환
                .flatMap(this.reactiveMathUseCase::findSqaure); // Map과 Flatmap 차이알아야함
    }

    @GetMapping("square/{input}/assignment")
    public Mono<ResponseEntity<TimesTable>> assignment(@PathVariable int input){
        return Mono.just(input)
                .filter(i -> i >=10 && i<= 20) // 해당 조건이 만족하면 (map) 아니라면 (defaultIfEmpty)
                .flatMap(this.reactiveMathUseCase::findSqaure)// Map과 Flatmap
                .map(ResponseEntity::ok) // 여기로 온다
                .defaultIfEmpty(ResponseEntity.badRequest().build()); // 아니라면 여기로
    }
    //
}

