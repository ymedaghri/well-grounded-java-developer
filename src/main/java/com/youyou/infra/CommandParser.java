package com.youyou.infra;

public class CommandParser {
    private final CommandFactory commandFactory;

    public CommandParser(CommandFactory commandFactory) {

        this.commandFactory = commandFactory;
    }

    public Command parse(String commandLiteral) {
        return commandFactory.createCommand(commandLiteral);
    }
}
