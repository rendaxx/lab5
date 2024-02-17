package com.rendaxx.commands;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class HelpCommand extends Command {

    private static final String NAME = "help";
    private static final String ARGS = "";
    private static final String DESC = "prints this list";

    private LinkedHashMap<String, Command> commandByName;

    public HelpCommand(LinkedHashMap<String, Command> linkedHashMap) {
        super(NAME, ARGS, DESC);
        this.commandByName = linkedHashMap;
    }

    @Override
    public void run(String[] args) throws IOException {
        commandByName.values().forEach(command ->
        {System.out.println(command.getName() + (command.getPossibleArgs().isEmpty() ? "" :  " ") + command.getPossibleArgs() + ": " + command.getDescription());});
    }
}
