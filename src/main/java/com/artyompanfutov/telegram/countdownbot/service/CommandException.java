package com.artyompanfutov.telegram.countdownbot.service;

public class CommandException extends RuntimeException {
    CommandException(String message) {
        super(message);
    }
}
