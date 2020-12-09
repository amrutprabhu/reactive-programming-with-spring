package com.amrut.prabhu.reactiveprogramming;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface Repository extends ReactiveCrudRepository<Person, Integer> {
}
