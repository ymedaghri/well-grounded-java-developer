package com.youyou.infra.commands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

class TerminationCommandTest {

    @Test
    @DisplayName("Execute should display the termination message")
    public void executeShouldDisplayCorrectMessage() {
        PrintStream consoleMock = mock(PrintStream.class);
        TerminationCommand terminationCommand = new TerminationCommand("quit", "quit description");
        terminationCommand.execute(consoleMock);
        InOrder inOrderVerify = inOrder(consoleMock);
        inOrderVerify.verify(consoleMock).println("Quitting the application");
        Mockito.verifyNoMoreInteractions(consoleMock);
    }

}