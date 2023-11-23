package com.example.webfluxdemo.common.handler;

import com.example.webfluxdemo.application.port.in.ReactiveMathUseCase;
import com.example.webfluxdemo.domain.TimesTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RouterHandler {

    private final ReactiveMathUseCase reactiveMathUseCase;

    public Mono<ServerResponse> squareHandler(ServerRequest serverRequest) {
        // PathVariable로 지정된 값을 읽어들인다.
        // 항상 String으로 받아온다.
        int input = Integer.parseInt(serverRequest.pathVariable("input"));
        //
        Mono<TimesTable> response = this.reactiveMathUseCase.findSqaure(input);
        // 파이프라인 구축
        // 간단한 문자열과 같은 응답 객체를 보내고 싶다면 bodyValue,
        // 퍼블리셔를 보내고 싶다면 body를 사용하면 된다. (퍼블리셔를 보낼때 방식)
        return ServerResponse.ok().body(response, TimesTable.class);

        // 새로운 응답을 보낼때는 해당 본문값을 사용할여 반환 한다.
//        TimesTable timesTable = new TimesTable(LocalDateTime.now(), input);
//        return ServerResponse.ok().bodyValue(timesTable);

    }
}
