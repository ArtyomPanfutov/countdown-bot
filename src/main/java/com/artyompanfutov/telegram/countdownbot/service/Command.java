package com.artyompanfutov.telegram.countdownbot.service;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.Nullable;

public interface Command {
    String getName();
    @Nullable
    BotApiMethod<Message> handle(Update update);

    default void validateName(Update update) {
        var command = update.getMessage().getText();
        if (!command.equalsIgnoreCase(getName())) {
            throw new CommandException("The name " + command + " does not match " + getName());
        }
    }
}
