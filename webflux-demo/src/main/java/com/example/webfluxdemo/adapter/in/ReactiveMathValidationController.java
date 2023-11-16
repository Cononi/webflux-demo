package com.example.webfluxdemo.adapter.in;

import com.example.webfluxdemo.application.port.in.ReactiveMathUseCase;
import com.example.webfluxdemo.common.ResponseCode;
import com.example.webfluxdemo.common.exception.InputValidException;
import com.example.webfluxdemo.domain.TimesTable;
import lombok.RequiredArgsConstructor;
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
}
