package com.ejournal.gateway_server.controller.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
//import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

//@Configuration
//@EnableWebFluxSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity security){
//        security.authorizeExchange(exchanges -> exchanges
//                                .pathMatchers("/university/**").permitAll()
//                                .pathMatchers("/group/**").permitAll()
//                                .pathMatchers("/journal/**").permitAll()
//                                .pathMatchers("/calendarplan/**").permitAll()
//
//                                .pathMatchers("/admin/university/").hasRole("ADMIN")
//                                .pathMatchers("/admin/analytics/").hasRole("ADMIN")
//
//                                .pathMatchers("/analytics/**").permitAll())
//                .oauth2ResourceServer(oAuth2ResServerSpec -> oAuth2ResServerSpec
//                                .jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter(grantedAuthoritiesExtractor())));
//
//        security.csrf(csrfSpec -> csrfSpec.disable());
//
//        return security.build();
//    }
//
//
//    private Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthoritiesExtractor(){
//        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//        converter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());
//        return new ReactiveJwtAuthenticationConverterAdapter(converter);
//    }

}
