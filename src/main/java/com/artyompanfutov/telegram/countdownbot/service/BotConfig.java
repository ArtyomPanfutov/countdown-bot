package com.artyompanfutov.telegram.countdownbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfig {
    @Value("${telegram.bot.token}")
    private String token;

    @Bean
    public CountDownBot countDownBot(StartCommand startCommand) throws TelegramApiException {
        final var api = new TelegramBotsApi(DefaultBotSession.class);
        final var bot = new CountDownBot(token, startCommand);

        api.registerBot(bot);

        return bot;

    }
}
