package com.example.webfluxdemo.adapter.in;

import com.example.webfluxdemo.application.port.in.ReactiveMathUseCase;
import com.example.webfluxdemo.domain.Multiply;
import com.example.webfluxdemo.domain.TimesTable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.AbstractJackson2Encoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

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

    @PostMapping("multiply")
    public Mono<TimesTable> multiply(
            @RequestBody Mono<Multiply> dtoMono,
            @RequestHeader Map<String, String> headers
    ){
        System.out.println(headers);
        return this.reactiveMathUseCase.multiplyMono(dtoMono);
    }
}
