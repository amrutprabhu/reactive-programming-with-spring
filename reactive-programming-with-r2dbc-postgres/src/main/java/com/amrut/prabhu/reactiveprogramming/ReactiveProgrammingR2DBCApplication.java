package com.amrut.prabhu.reactiveprogramming;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Flux;

@SpringBootApplication
@Log4j2
public class ReactiveProgrammingR2DBCApplication {

    @Autowired
    private Repository repository;

    public static void main(String[] args) {
        SpringApplication.run(ReactiveProgrammingR2DBCApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {

        Flux<Person> personFlux = Flux.just("name1", "name2", "name3")
                .map(name -> new Person(null, name))
                .flatMap(person -> repository.save(person));

        repository.deleteAll()
                .thenMany(personFlux)
                .thenMany(this.repository.findAll())
                .subscribe(log::info);

    }

}
