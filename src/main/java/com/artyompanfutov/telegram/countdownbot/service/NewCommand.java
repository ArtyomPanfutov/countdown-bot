package com.artyompanfutov.telegram.countdownbot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.Nullable;
import java.time.format.DateTimeFormatter;

@Component
public class NewCommand implements Command {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss x");

    @Override
    public String getName() {
        return "/new";
    }

    @Nullable
    @Override
    public BotApiMethod<Message> handle(Update update) {
        validateName(update);
        var message = update.getMessage();

        var split = message.getText().split(" ");

        if (split.length != 5) {
            throw new CommandException("Incorrect message");
        }
        System.out.println("Message: " + message);

        final var name = split[1];
        final var datetime = FORMATTER.parse(split[2] + " " + split[3] + " " + split[4]);

        System.out.println("Name " + name + " Datetime " + datetime);

        var retMessage = new SendMessage();
        retMessage.setChatId(update.getMessage().getChatId().toString());
        retMessage.setText(String.format("The countdown %s has been successfully registered!", name));

        return retMessage;
    }
}
