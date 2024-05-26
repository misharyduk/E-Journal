package com.ejournal.gateway_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/contactSupport")
    public Mono<String> contactSupport(){
        return Mono.just("Виникла помилка. " +
                "Будь-ласка, спробуйте ще раз через певний час " +
                "або зверність до служби підтримки E-Journal за " +
                "поштою support.e-journal@gmail.com");
    }

}
