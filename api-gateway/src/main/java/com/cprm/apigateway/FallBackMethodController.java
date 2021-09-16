package com.cprm.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public Mono<String> userServiceFallBackMethod(){
        return Mono.just("User Service taking longer time than Expected"+
                "Please try again later");
    }

    @GetMapping("/departmentServiceFallBack")
    public Mono<String> departmentServiceFallBackMethod(){
        return Mono.just("Department Service taking longer time than Expected"+
                "Please try again later");
    }
}
