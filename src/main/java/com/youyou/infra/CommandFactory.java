package com.youyou.infra;

import java.util.List;

public interface CommandFactory {
    Command retrieveCommand(String commandLiteral);

    void initializeWith(Command... commands);

    List<Command> getAvailableCommands();

}
