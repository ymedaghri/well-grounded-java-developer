package com.youyou.infra.commands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

class UnknownCommandTest {

    @Test
    @DisplayName("Execute should display the unknown command message")
    public void executeShouldDisplayCorrectMessage() {
        PrintStream consoleMock = mock(PrintStream.class);
        UnknownCommand unknownCommand = new UnknownCommand();
        unknownCommand.execute(consoleMock);
        InOrder inOrderVerify = inOrder(consoleMock);
        inOrderVerify.verify(consoleMock).println("Unknown Command, please retype another command.");
        Mockito.verifyNoMoreInteractions(consoleMock);
    }

}