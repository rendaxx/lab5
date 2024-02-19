package com.rendaxx;

import com.rendaxx.commands.*;
import com.rendaxx.exceptions.UnknownCommandException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;
import java.util.LinkedHashMap;

public class CommandManager {
    private LinkedHashMap<String, Command> commandByName;

    public CommandManager(CollectionServer server) {
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
        commandByName.put("exit", new ExitCommand());
        commandByName.put("add_if_min", new AddIfMinCommand(server));
        commandByName.put("remove_greater", new RemoveGreaterCommand(server));
        commandByName.put("remove_lower", new RemoveLowerCommand(server));
        commandByName.put("sum_of_annual_turnover", new SumOfAnnualCommand(server));
        commandByName.put("filter_starts_with_name", new FilterStartsCommand(server));
        commandByName.put("print_field_ascending_full_name", new PrintAscendingFullCommand(server));

    }


    public void execute(CommandInput input) throws UnknownCommandException, IOException, WrongInputException {
        Command command = commandByName.get(input.getName());
        if (command == null) {
            throw new UnknownCommandException(input.getName());
        }
        command.run(input.getArgs());
    }
}
