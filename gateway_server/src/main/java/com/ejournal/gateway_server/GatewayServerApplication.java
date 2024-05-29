package com.ejournal.gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.cloud.gateway.support.RouteMetadataUtils.CONNECT_TIMEOUT_ATTR;
import static org.springframework.cloud.gateway.support.RouteMetadataUtils.RESPONSE_TIMEOUT_ATTR;

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
                                        .setName("universityCircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport"))
                                .retry(retryConfig -> retryConfig
                                        .setMethods(HttpMethod.GET)
                                        .setRetries(3)
                                        .setBackoff(Duration.ofMillis(1000),
                                                    Duration.ofMillis(5000),
                                                2, true))
//                                .requestRateLimiter(rateLimiterConfig -> rateLimiterConfig
//                                        .setRateLimiter(redisRateLimiter())
//                                        .setKeyResolver(ipKeyResolver()))
                        )
                        .uri("lb://UNIVERSITY")
                )
                .route(r -> r
                        .path("/group/**")
                        .filters(f -> f.rewritePath("/group/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(circBreakConfig -> circBreakConfig
                                        .setName("groupCircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport"))
//                                .requestRateLimiter(rateLimiterConfig -> rateLimiterConfig
//                                        .setRateLimiter(redisRateLimiter())
//                                        .setKeyResolver(ipKeyResolver()))
                        )
                        .uri("lb://GROUP")
                )
                .route(r -> r
                        .path("/journal/**")
                        .filters(f -> f.rewritePath("/journal/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(circBreakConfig -> circBreakConfig
                                        .setName("journalCircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport"))
//                                .requestRateLimiter(rateLimiterConfig -> rateLimiterConfig
//                                        .setRateLimiter(redisRateLimiter())
//                                        .setKeyResolver(ipKeyResolver()))
                        )
                        .uri("lb://JOURNAL")
                ).route(r -> r
                        .path("/analytics/**")
                        .filters(f -> f.rewritePath("/analytics/(?<segment>.*)", "/${segment}"))
                        .metadata(CONNECT_TIMEOUT_ATTR, 2000)
                        .metadata(RESPONSE_TIMEOUT_ATTR, 15000)
                        .uri("lb://ANALYTICS")
                ).route(r -> r
                        .path("/calendarplan/**")
                        .filters(f -> f.rewritePath("/calendarplan/(?<segment>.*)", "/${segment}")
                                .circuitBreaker(circBreakConfig -> circBreakConfig
                                        .setName("calendarPlanCircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport"))
//                                .requestRateLimiter(rateLimiterConfig -> rateLimiterConfig
//                                        .setRateLimiter(redisRateLimiter())
//                                        .setKeyResolver(ipKeyResolver()))
                        )
                        .uri("lb://CALENDARPLAN")
                )
                .build();
    }


//    @Bean
//    public RedisRateLimiter redisRateLimiter(){
//        return new RedisRateLimiter(10, 100, 10);
//    }
//
//    @Bean
//    public KeyResolver ipKeyResolver(){
//        return exchange -> Mono.just(
//                exchange.getRequest().getRemoteAddress().getAddress().toString()
//        );
//    }
}
