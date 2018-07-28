package com.youyou.infra;

import com.youyou.infra.commands.UnknownCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Arrays;

class DefaultCommandFactoryTest {

    private DefaultCommandFactory defaultCommandFactory;

    public static final Command COMMAND_1 = buildCommand("C1", "DESCRIPTION C1");
    public static final Command COMMAND_2 = buildCommand("C2", "DESCRIPTION C2");

    @BeforeEach
    public void setUp() {
        defaultCommandFactory = new DefaultCommandFactory();
        defaultCommandFactory.initializeWith(COMMAND_1, COMMAND_2);
    }

    @Test
    @DisplayName("Should retrieve a command by its key")
    public void shouldRetrieveACommandByItsKey() {
        Command c1 = defaultCommandFactory.retrieveCommand("C1");
        Assertions.assertEquals(COMMAND_1, c1);
    }

    @Test
    @DisplayName("Should retrieve the unknown command for an unknown key")
    public void shouldRetrieveTheUnknownCommandForAnUnknownKey() {
        Command c1 = defaultCommandFactory.retrieveCommand("Cx");
        Assertions.assertEquals(UnknownCommand.class, c1.getClass());
    }

    @Test
    @DisplayName("Should throw an exception when retrieving from an empty directory")
    public void shouldThrowAnExceptionWhenRetrieveACommandFromAnEmptyDirectory() {
        Assertions.assertThrows(IllegalStateException.class, () -> new DefaultCommandFactory().retrieveCommand(null));
    }

    @Test
    @DisplayName("Should display available commands")
    public void shouldDisplayAvailableCommands() {
        Assertions.assertIterableEquals(Arrays.asList(COMMAND_1, COMMAND_2), defaultCommandFactory.getAvailableCommands());
    }

    private static Command buildCommand(final String key, final String description) {
        return new Command(key, description) {
            @Override
            public void execute(PrintStream console) {

            }
        };
    }
}