package com.artyompanfutov.telegram.countdownbot.commands;

public class CommandException extends RuntimeException {
    public CommandException(String message) {
        super(message);
    }
}
