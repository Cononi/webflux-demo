package com.example.webfluxdemo.common.config;

import com.example.webfluxdemo.common.handler.RouterHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {

    private final RouterHandler routerHandler;
    @Bean
    public RouterFunction<ServerResponse> serverResponseRouterFunction(){
        return RouterFunctions.route()
                .GET("router/{input}", routerHandler::squareHandler)
                .build();
    }

}
