package com.artyompanfutov.telegram.countdownbot.service;

import com.artyompanfutov.telegram.countdownbot.commands.CommandSelector;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CountDownBot extends TelegramLongPollingBot {

    private final String token;

    private final CommandSelector commandSelector;

    public CountDownBot(String token, CommandSelector commandSelector) throws TelegramApiException {
        this.token = token;
        this.commandSelector = commandSelector;
    }

    @Override
    public String getBotUsername() {
        return "Countdown_Bot";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        handleCommand(update);
    }

    private void handleCommand(Update update) {
        final var retMessage = commandSelector.select(update.getMessage().getText()).handle(update);

        sendMessage(retMessage);
    }

    private void sendMessage(BotApiMethod<Message> message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

