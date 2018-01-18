package com.robert.demo.router;


import com.robert.demo.repository.UserRepository;
import com.robert.demo.repository.domain.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;

@Configuration
public class RouterConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> getAllUser(UserRepository userRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/user/all"),
                request -> {
                    Flux<UserInfo> flux = Flux.fromIterable(userRepository.getUser());
                    return ServerResponse.ok().body(flux, UserInfo.class);
                });
    }

}
