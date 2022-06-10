package com.artyompanfutov.telegram.countdownbot.service;

import com.artyompanfutov.telegram.countdownbot.commands.Command;
import com.artyompanfutov.telegram.countdownbot.commands.CommandSelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CountDownBotTest {

    private static final String TOKEN = "1234567890";

    private static final String BOT_NAME = "Countdown_Bot";

    @Mock
    private Command newCommand;

    @Mock
    private Command startCommand;

    @Mock
    private Command checkCommand;

    private Set<Command> commands;

    private CountDownBot bot;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

        commands = Set.of(newCommand, startCommand, checkCommand);
        bot = new CountDownBot(TOKEN, new CommandSelector(commands));
    }

    @Test
    void shouldMatchName() {
        final var botUsername = bot.getBotUsername();
        assertEquals(BOT_NAME, botUsername);
    }

    @Test
    void shouldMatchToken() {
        final var token = bot.getBotToken();
        assertEquals(TOKEN, token);
    }

}