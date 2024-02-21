package com.rendaxx.commands;

import com.rendaxx.exceptions.WrongInputException;

/**
 * Class for exit command. This command exits the program.
 */
public class ExitCommand extends Command {
    private static final String NAME = "exit";
    private static final String ARGS = "";
    private static final String DESC = "exits the program";

    public ExitCommand() {
        super(NAME, ARGS, DESC);
    }
    /**
     * Exits the program.
     * @param args arguments for command
     */
    @Override
    public void run(String[] args) throws WrongInputException {
        if (args != null) {
            throw new WrongInputException("Wrong amount of args");
        }
        System.exit(0);
    }
}
