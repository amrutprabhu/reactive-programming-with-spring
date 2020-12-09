package com.amrut.prabhu.reactive;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
@Log4j2
public class ReactiveProgrammingRestServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveProgrammingRestServicesApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        WebClient webClient = WebClient.create("http://localhost:8080");

        Flux.just("/request", "/error", "/request")
                .log()
                .flatMap(uri ->
                        webClient.get()
                                .uri(uri)
                                .retrieve()
                                .bodyToFlux(String.class))
                .onErrorResume(exception -> Flux.just(exception.getMessage()))
                .doOnComplete(() -> log.info("On complete called."))
                .subscribe(consume -> System.out.println("printed from subscriber:" + consume));

    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadySampleFluxExecution() {
        Flux.just(2, 4, 0, 5, 6)
                .log()
                .map(value -> 24 / value)
                .onErrorResume(RuntimeException.class, exception -> Flux.just(0, 10, 20))
                .doOnComplete(() -> log.info("The stream is now complete"))
                .subscribe(message -> log.info("Consumer consumed: " + message));

    }

}
