package com.artyompanfutov.telegram.countdownbot.service;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CommandSelector {
    private final Set<Command> commands;

    public CommandSelector(Set<Command> commands) {
        this.commands = commands;
    }

    public Command select(String command) {
        return commands.stream()
                .filter(c -> c.getName().equalsIgnoreCase(command))
                .findFirst()
                .orElseThrow();
    }
}
