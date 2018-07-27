package com.youyou.infra.commands;

import com.youyou.infra.Command;

import java.io.PrintStream;

public class TerminationCommand extends Command {
    public TerminationCommand(String key, String description) {
        super(key, description);
    }

    @Override
    public void execute(PrintStream console) {
        System.out.println("Quitting the application");
    }
}
