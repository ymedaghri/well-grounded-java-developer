package com.youyou.infra.commands;

import com.youyou.infra.Command;
import com.youyou.infra.CommandFactory;

import java.io.PrintStream;
import java.util.List;

public class HelpCommand extends Command {
    private final CommandFactory factory;

    public HelpCommand(String key, String description, CommandFactory factory) {
        super(key, description);
        this.factory = factory;
    }

    @Override
    public void execute(PrintStream console) {
        console.println("Help Menu :");
        console.println("-----------");
        List<Command> availableCommands = factory.getAvailableCommands();
        availableCommands.forEach(command -> console.printf("%s : %s\n", command.getKey(), command.getDescription()));
    }
}
