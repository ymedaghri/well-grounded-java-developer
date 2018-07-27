package com.youyou.examples;

import com.youyou.infra.Command;

import java.io.IOException;
import java.sql.SQLException;

public class WellGroundedCommand_Try_with_resources extends Command {
    public WellGroundedCommand_Try_with_resources(String key, String description) {
        super(key, description);
    }

    @Override
    public void execute() {
        try {
            main();
        } catch (IOException | SQLException e) {
            System.out.printf("Exception of type %s has been thrown\n", e.getClass().getName());
        }
    }

    private void main() throws IOException, SQLException {
        try {
            doSomethingWhichMightThrowIOException();
            doSomethingElseWhichMightThrowSQLException();
        } catch (final Exception e) {
            throw e;
        }
    }

    private void doSomethingWhichMightThrowIOException() throws IOException {
        throw new IOException("IOException thrown");
    }

    private void doSomethingElseWhichMightThrowSQLException() throws SQLException {
        throw new SQLException("SQLException thrown");
    }
}
