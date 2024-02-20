package com.rendaxx.commands;

import java.io.IOException;
import java.util.LinkedHashMap;

public class HelpCommand extends Command {

    private static final String NAME = "help";
    private static final String ARGS = "";
    private static final String DESC = "prints this list";

    private final LinkedHashMap<String, Command> commandByName;

    public HelpCommand(LinkedHashMap<String, Command> linkedHashMap) {
        super(NAME, ARGS, DESC);
        this.commandByName = linkedHashMap;
    }

    @Override
    public void run(String[] args) {
        commandByName.values().forEach(System.out::println);
    }
}
