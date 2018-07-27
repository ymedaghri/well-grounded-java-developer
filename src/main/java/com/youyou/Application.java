package com.youyou;

import com.youyou.examples.WellGroundedCommand_Exception_Rethrow;
import com.youyou.infra.Command;
import com.youyou.infra.CommandParser;
import com.youyou.infra.DefaultCommandFactory;
import com.youyou.infra.commands.HelpCommand;
import com.youyou.infra.commands.TerminationCommand;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DefaultCommandFactory defaultCommandFactory = new DefaultCommandFactory();
        defaultCommandFactory.initializeWith(
                new HelpCommand("help", "Show the help Menu", defaultCommandFactory),
                new TerminationCommand("quit", "Quit the com.youyou.Application"),
                new WellGroundedCommand_Exception_Rethrow("1", "Exception Re-throw Example"));

        CommandParser commandParser = new CommandParser(defaultCommandFactory);
        Command command;
        do {
            command = commandParser.parse(in.nextLine());
            command.execute();
        } while (!(command instanceof TerminationCommand));


    }
}
