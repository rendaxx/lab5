package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class AddIfMinCommand extends Command {
    private static final String NAME = "add_if_min";
    private static final String ARGS = "{element}";
    private static final String DESC = "adds {element} in collection if its value is lower than collection's minimum";

    CollectionServer collectionServer;
    public AddIfMinCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }

    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        collectionServer.addIfMin();
    }
}
