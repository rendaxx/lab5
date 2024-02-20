package com.rendaxx.commands;

import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;
import lombok.Getter;

import java.io.IOException;

@Getter
public abstract class Command {
    private final String name;
    private final String possibleArgs;
    private final String description;


    public Command(String name, String possibleArgs, String description) {
        this.name = name;
        this.possibleArgs = possibleArgs;
        this.description = description;
    }

    @Override
    public String toString() {
        return getName() + (getPossibleArgs().isEmpty() ? "" : " ") + getPossibleArgs() + ": " + getDescription();
    }

    public abstract void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException;
}
