package com.youyou.infra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Arrays;

class DefaultCommandFactoryTest {

    @BeforeEach
    public void setUp() {

        Command c1 = createCommand("C1", "DESCRIPTION C1");
        Command c2 = createCommand("C2", "DESCRIPTION C2");


    }

    private Command createCommand(final String key, final String description) {
        return new Command(key, description) {
            @Override
            public void execute(PrintStream console) {

            }
        };
    }

    @Test
    public void shouldDisplayAvailableCommands() {
        DefaultCommandFactory defaultCommandFactory = new DefaultCommandFactory();
        defaultCommandFactory.initializeWith();
        Assertions.assertIterableEquals(Arrays.asList(), defaultCommandFactory.getAvailableCommands());
    }
}