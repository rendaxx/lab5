package com.rendaxx;

import com.rendaxx.commands.AddCommand;
import com.rendaxx.commands.Command;
import com.rendaxx.exceptions.UnknownCommandException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class CommandManager {
    private HashMap<String, Command> commandByName;

    public CommandManager(Scanner in, OrganizationServer server) {
        commandByName = new HashMap<>();
        commandByName.put("add", new AddCommand(server));
    }

    public void addNewCommand(Command c) {
        commandByName.put(c.getName(), c);
    }

    public void execute(CommandInput input) throws UnknownCommandException {
        Command command = commandByName.get(input.getName());
        if (command == null) {
            throw new UnknownCommandException(input.getName());
        }
        command.run(input.getArgs());
    }
}
