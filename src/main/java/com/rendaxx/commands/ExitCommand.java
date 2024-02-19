package com.rendaxx.commands;

import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class ExitCommand extends Command {
    private static final String NAME = "exit";
    private static final String ARGS = "";
    private static final String DESC = "exits the program";

    public ExitCommand() {
        super(NAME, ARGS, DESC);
    }

    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        System.exit(0);
    }
}
