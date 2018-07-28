package com.youyou.infra;

import java.io.PrintStream;

public abstract class Command {
    private final String key;

    private final String description;

    public Command(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(PrintStream console);

    @Override
    public String toString() {
        return "Command{" +
                "key='" + key + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
