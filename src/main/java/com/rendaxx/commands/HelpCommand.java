package com.rendaxx.commands;

import com.rendaxx.exceptions.WrongInputException;

import java.util.LinkedHashMap;
/**
 * Class for help command. This command prints list of available commands.
 */
public class HelpCommand extends Command {
    private static final String NAME = "help";
    private static final String ARGS = "";
    private static final String DESC = "prints this list";

    private final LinkedHashMap<String, Command> commandByName;

    public HelpCommand(LinkedHashMap<String, Command> linkedHashMap) {
        super(NAME, ARGS, DESC);
        this.commandByName = linkedHashMap;
    }
    /**
     * Prints list of available commands.
     * @param args arguments for command
     */
    @Override
    public void run(String[] args) throws WrongInputException {
        if (args != null) {
            throw new WrongInputException("Wrong amount of args");
        }
        commandByName.values().forEach(System.out::println);
    }
}
