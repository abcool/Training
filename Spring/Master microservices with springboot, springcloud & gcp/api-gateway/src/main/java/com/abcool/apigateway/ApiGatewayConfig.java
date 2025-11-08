package com.abcool.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                // call authentication & authorization services
                .route(p->p.path("/get")
                        .filters(f->f.addRequestHeader("My Header: ","My Custom Header"))
                        .uri("http://httpbin.org:80"))
                //after successful authentication redirect to API picking correct instance from eureka
                .route(x->x.path("/currency-conversion/**")
                        .uri("lb://currency-conversion-service"))
                // mapping a custom url to an API URI
                .route(y->y.path("/my-custom-url/**")
                        .filters(f->f.rewritePath("/my-custom-url/(?<segment>.*)",
                                "/currency-conversion/${segment}"))
                        .uri("lb://currency-conversion-service"))
                .build();
    }
}
