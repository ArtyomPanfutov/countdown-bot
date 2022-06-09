package com.artyompanfutov.telegram.countdownbot.repository;

import com.artyompanfutov.telegram.countdownbot.entity.Countdown;
import org.springframework.data.repository.CrudRepository;

public interface CountdownRepository extends CrudRepository<Countdown, Integer> {
}
