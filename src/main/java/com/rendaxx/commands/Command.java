package com.rendaxx.commands;

import java.io.EOFException;

public abstract class Command {
    private final String name;
    private final String possibleArgs;
    private final String description;


    public Command(String name, String possibleArgs, String description) {
        this.name = name;
        this.possibleArgs = possibleArgs;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPossibleArgs() {
        return possibleArgs;
    }

    public String getDescription() {
        return description;
    }

    public abstract void run(String[] args) throws EOFException;
}
