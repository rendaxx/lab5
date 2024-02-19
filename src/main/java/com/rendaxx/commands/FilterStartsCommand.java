package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class FilterStartsCommand extends Command {
    private static final String NAME = "filter_starts_with_name";
    private static final String ARGS = "name";
    private static final String DESC = "prints all elements whose name field starts with {name}";

    CollectionServer collectionServer;
    public FilterStartsCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }

    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        if (args.length != 1) {
            throw new InvalidArgumentCountException();
        }
        String name = args[0];
        collectionServer.filterStartsWithName(name);
    }
}
