package com.youyou.infra.commands;

import com.youyou.infra.Command;

public class TerminationCommand extends Command {
    public TerminationCommand(String key, String description) {
        super(key, description);
    }

    @Override
    public void execute() {
        System.out.println("Quitting the application");
    }
}
