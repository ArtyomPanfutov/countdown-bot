package com.artyompanfutov.telegram.countdownbot.repository;

import com.artyompanfutov.telegram.countdownbot.entity.Countdown;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountdownRepository extends CrudRepository<Countdown, Integer> {
    boolean existsByName(String name);
}
