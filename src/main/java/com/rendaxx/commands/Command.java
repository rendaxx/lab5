package com.rendaxx.commands;

import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;
import lombok.Getter;

import java.io.IOException;

/**
 * Abstract class for all commands. Each command has name, possible arguments and description. Each command has to implement run method.
 */
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
    /**
     * Method for executing command.
     * @param args command arguments
     * @throws IOException if an I/O error occurs
     * @throws InvalidArgumentCountException if there is invalid number of arguments
     * @throws WrongInputException if there is an error in input
     */
    public abstract void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException;
}
