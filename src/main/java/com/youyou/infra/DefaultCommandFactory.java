package com.youyou.infra;

import com.youyou.infra.commands.UnknownCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultCommandFactory implements CommandFactory {

    private final Map<String, Command> directory = new HashMap<>();


    @Override
    public Command createCommand(String commandLiteral) {
        if (directory.isEmpty())
            throw new IllegalStateException("Directory is empty, it need to be initialized by adding commands to it.");
        return directory.getOrDefault(commandLiteral, new UnknownCommand());
    }

    @Override
    public void initializeWith(Command... commands) {
        for (Command command : commands) {
            directory.put(command.getKey(), command);
        }
    }

    @Override
    public List<Command> getAvailableCommands() {
        return directory.entrySet().stream().map(entrySet -> entrySet.getValue()).collect(Collectors.toList());
    }
}
