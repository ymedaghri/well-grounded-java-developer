package com.youyou.infra.commands;

import com.youyou.infra.Command;
import com.youyou.infra.CommandFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class HelpCommandTest {


    private CommandFactory factoryMock;

    @BeforeEach
    public void setUp() {
        factoryMock = mock(CommandFactory.class);
        Command testCommand = new Command("test", "test description") {
            @Override
            public void execute(PrintStream console) {

            }
        };

        when(factoryMock.getAvailableCommands()).thenReturn(Arrays.asList(testCommand));
    }

    @Test
    @DisplayName("Execute should display Help menu")
    public void executeShouldDisplayHelpMenu() {
        PrintStream consoleMock = mock(PrintStream.class);
        HelpCommand helpCommand = new HelpCommand("help", "help description", factoryMock);
        helpCommand.execute(consoleMock);
        InOrder inOrderVerify = inOrder(consoleMock);
        inOrderVerify.verify(consoleMock).println("Help Menu :");
        inOrderVerify.verify(consoleMock).println("-----------");
        inOrderVerify.verify(consoleMock).printf("%s : %s\n","test", "test description");
        Mockito.verifyNoMoreInteractions(consoleMock);


    }

}