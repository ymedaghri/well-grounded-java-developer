package com.youyou;

import com.youyou.examples.WellGroundedCommand_Exception_Rethrow;
import com.youyou.infra.Command;
import com.youyou.infra.DefaultCommandFactory;
import com.youyou.infra.commands.HelpCommand;
import com.youyou.infra.commands.TerminationCommand;

import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Application {

    private static final int READING_PAGE_NUMBER = 40;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DefaultCommandFactory defaultCommandFactory = initializeCommands();
        showWelcomeMessage(defaultCommandFactory);

        Command command;
        do {
            command = defaultCommandFactory.createCommand(in.nextLine());
            clearConsole();
            command.execute();
        } while (!(command instanceof TerminationCommand));

    }

    private static void clearConsole() {
        IntStream.range(0,30).forEach(value -> System.out.println());
    }

    private static void showWelcomeMessage(DefaultCommandFactory defaultCommandFactory) {
        out.println("Well Grounded Java Developer examples");
        out.println("-------------------------------------");
        out.println("Currently reading the book at page " + READING_PAGE_NUMBER);
        out.println();
        defaultCommandFactory.createCommand("help").execute();
    }

    private static DefaultCommandFactory initializeCommands() {
        DefaultCommandFactory defaultCommandFactory = new DefaultCommandFactory();
        defaultCommandFactory.initializeWith(
                new HelpCommand("help", "Show the help Menu", defaultCommandFactory),
                new TerminationCommand("quit", "Quit the com.youyou.Application"),
                new WellGroundedCommand_Exception_Rethrow("1", "Exception Re-throw Example"));
        return defaultCommandFactory;
    }
}
