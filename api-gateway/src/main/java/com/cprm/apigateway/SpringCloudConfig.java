package com.cprm.apigateway;

import org.springframework.context.annotation.Configuration;

//@EnableHystrix
@Configuration
public class SpringCloudConfig {

    /*@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/users/**")
                        .filters(f -> f.addRequestHeader("hello","world"))
                        .uri("lb://USER-SERVICE"))
                .route(r -> r.path("/departments/**")
                        .filters(f -> f.addRequestHeader("hello","world"))
                        .uri("lb://DEPARTMENT-SERVICE"))
                .build();
    }*/

/*    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/users/**")
                        .filters(f -> f.hystrix(h -> h.setName("Hystrix")
                                .setFallbackUri("forward:/userServiceFallBack")))
                        .uri("lb://USER-SERVICE")
                        .id("USER-SERVICE"))

                .route(r -> r.path("/departments/**")
                        .filters(f -> f.hystrix(h -> h.setName("Hystrix")
                                .setFallbackUri("forward:/departmentServiceFallBack")))
                        .uri("lb://DEPARTMENT-SERVICE")
                        .id("DEPARTMENT-SERVICE"))
                .build();
    }*/

}
