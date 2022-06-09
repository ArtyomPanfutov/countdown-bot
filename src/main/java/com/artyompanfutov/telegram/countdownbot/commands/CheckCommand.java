package com.artyompanfutov.telegram.countdownbot.commands;

import com.artyompanfutov.telegram.countdownbot.entity.Countdown;
import com.artyompanfutov.telegram.countdownbot.repository.CountdownRepository;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.Nullable;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
public class CheckCommand implements Command {

    private final CountdownRepository countdownRepository;

    public CheckCommand(CountdownRepository countdownRepository) {
        this.countdownRepository = countdownRepository;
    }

    @Override
    public String getName() {
        return "/check";
    }

    @Nullable
    @Override
    public BotApiMethod<Message> handle(Update update) {
        validateName(update);

        final var split = update.getMessage().getText().split(" ");
        final var name =  split[1];

        final var found = countdownRepository.findByName(name);

        final var retMessage = new SendMessage();
        if (found.isEmpty()) {
            retMessage.setChatId(update.getMessage().getChatId().toString());
            retMessage.setText("The countdown with name " + name + " is not found.");

            return retMessage;
        }

        final var target = found.get().getTimeStamp();
        final var now = OffsetDateTime.now(target.getOffset());
        final var diff = Duration.between(now, target);

        retMessage.setChatId(update.getMessage().getChatId().toString());
        retMessage.setText(String.format("The remaining time: %s days %s hours %s minutes",
            diff.toDaysPart(),
            diff.toHoursPart(),
            diff.toMinutesPart()));

        return retMessage;
    }
}
