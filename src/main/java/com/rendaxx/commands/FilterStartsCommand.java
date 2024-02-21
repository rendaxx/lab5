package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;
/**
 * Class for filter_starts_with_name command. This command prints all elements whose name field starts with {name}.
 * @see CollectionServer
 */
public class FilterStartsCommand extends Command {
    private static final String NAME = "filter_starts_with_name";
    private static final String ARGS = "name";
    private static final String DESC = "prints all elements whose name field starts with {name}";

    final CollectionServer collectionServer;
    public FilterStartsCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Prints all elements whose name field starts with {name}.
     * @param args arguments for command
     * @throws InvalidArgumentCountException if argument count is incorrect
     * @throws WrongInputException if input is incorrect
     */
    @Override
    public void run(String[] args) throws InvalidArgumentCountException, WrongInputException {
        if (args.length != 1) {
            throw new InvalidArgumentCountException();
        }
        String name = args[0];
        collectionServer.filterStartsWithName(name);
    }
}
