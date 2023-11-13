package com.example.webfluxdemo.adapter.in;

import com.example.webfluxdemo.application.port.in.ReactiveMathUseCase;
import com.example.webfluxdemo.domain.TimesTable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.AbstractJackson2Encoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
@RequiredArgsConstructor
public class ReactiveMathController {

    private final ReactiveMathUseCase reactiveMathUseCase;

    @GetMapping("square/{input}")
    public Mono<TimesTable> findSquare(@PathVariable int input){
        return this.reactiveMathUseCase.findSqaure(input);
    }

    @GetMapping(value = "table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TimesTable> multiplicationTableStream(@PathVariable int input){
        return this.reactiveMathUseCase.multiplicationTable(input);
    }

    @GetMapping(value = "table/{input}/async-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TimesTable> asyncMultiplicationTableStream(@PathVariable int input){
        return this.reactiveMathUseCase.asyncMultiplicationTable(input);
    }
}
