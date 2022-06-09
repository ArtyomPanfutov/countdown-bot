package com.artyompanfutov.telegram.countdownbot.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand implements Command {

    public static final String COMMAND_NAME = "/start";

    @Override
    public String getName() {
        return COMMAND_NAME;
    }

    @Override
    public BotApiMethod<Message> handle(Update update) {
        validateName(update);

        final var message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("Hi there! \nYou can create a new countdown with the command '/new <name> <date and time in format dd/mm/yy hh:mm:ss> <localized zone-offset>', eg: \\new somecountdown 21/12/2029 00:00:00 GMT+3:00. Or you can check already existing by using the command '/check <count down name>'");

        return message;
    }
}
