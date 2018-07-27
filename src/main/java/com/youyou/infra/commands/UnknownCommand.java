package com.youyou.infra.commands;

import com.youyou.infra.Command;

import java.io.PrintStream;

public class UnknownCommand extends Command {
    public UnknownCommand() {
        super(null, null);
    }

    @Override
    public void execute(PrintStream console) {
        System.out.println("Unknown Command, please retype another command.");
    }
}
