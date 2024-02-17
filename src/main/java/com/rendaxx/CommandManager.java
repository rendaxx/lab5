package com.rendaxx;

import com.rendaxx.commands.*;
import com.rendaxx.exceptions.UnknownCommandException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;
import java.util.LinkedHashMap;

public class CommandManager {
    private LinkedHashMap<String, Command> commandByName;

    public CommandManager(OrganizationServer server) {
        commandByName = new LinkedHashMap<>();
        commandByName.put("help", new HelpCommand(commandByName));
        commandByName.put("info", new InfoCommand(server));
        commandByName.put("show", new ShowCommand(server));
        commandByName.put("add", new AddCommand(server));
        commandByName.put("update", new UpdateCommand(server));
        commandByName.put("remove_by_id", new RemoveByIDCommand(server));
        commandByName.put("clear", new ClearCommand(server));
        // TODO: save command
        commandByName.put("execute_script", new ExecuteScriptCommand());
        // TODO: exit command
        commandByName.put("add_if_min", new AddIfMinCommand(server));
        // TODO remove greater
        // TODO remove greater
        // TODO sum_of_annual
        // TODO filter_starts_with_name
        // TODO print_ascending_full


    }

    public void addNewCommand(Command c) {
        commandByName.put(c.getName(), c);
    }

    public void execute(CommandInput input) throws UnknownCommandException, IOException, WrongInputException {
        Command command = commandByName.get(input.getName());
        if (command == null) {
            throw new UnknownCommandException(input.getName());
        }
        command.run(input.getArgs());
    }
}
