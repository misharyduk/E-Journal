package com.ejournal.gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

    @Bean
    public RouteLocator systemRouteConfiguration(RouteLocatorBuilder routeLocatorConfig){
        return routeLocatorConfig.routes()
                .route(r -> r
                        .path("/university/**")
                        .filters(f -> f.rewritePath("/university/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(circBreakConfig -> circBreakConfig
                                        .setName("universityCircuitBreaker")))
                        .uri("lb://UNIVERSITY")
                )
                .route(r -> r
                        .path("/group/**")
                        .filters(f -> f.rewritePath("/group/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(circBreakConfig -> circBreakConfig
                                        .setName("groupCircuitBreaker")))
                        .uri("lb://GROUP")
                )
                .route(r -> r
                        .path("/journal/**")
                        .filters(f -> f.rewritePath("/journal/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(circBreakConfig -> circBreakConfig
                                        .setName("journalCircuitBreaker")))
                        .uri("lb://JOURNAL")
                ).route(r -> r
                        .path("/analytics/**")
                        .filters(f -> f.rewritePath("/analytics/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(circBreakConfig -> circBreakConfig
                                        .setName("analyticsCircuitBreaker")))
                        .uri("lb://ANALYTICS")
                ).route(r -> r
                        .path("/calendarplan/**")
                        .filters(f -> f.rewritePath("/calendarplan/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(circBreakConfig -> circBreakConfig
                                        .setName("calendarPlanCircuitBreaker")))
                        .uri("lb://CALENDARPLAN")
                )
                .build();
    }
}
