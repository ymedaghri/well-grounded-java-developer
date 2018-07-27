package com.youyou.infra.commands;

import com.youyou.infra.Command;

public class UnknownCommand extends Command {
    public UnknownCommand() {
        super(null, null);
    }

    @Override
    public void execute() {
        System.out.println("Unknown Command, please retype another command.");
    }
}
