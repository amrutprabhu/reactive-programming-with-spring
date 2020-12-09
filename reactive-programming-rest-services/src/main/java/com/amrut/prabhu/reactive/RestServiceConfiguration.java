package com.amrut.prabhu.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RestServiceConfiguration {

    @Bean
    RouterFunction<ServerResponse> serverResponseRouterFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/request"), request ->
                ServerResponse.ok().bodyValue("Ok response")
        );
    }

}
