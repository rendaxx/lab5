package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class RemoveGreaterCommand extends Command {
    private static final String NAME = "remove_greater";
    private static final String ARGS = "{element}";
    private static final String DESC = "removes all elements greater that {element}";

    CollectionServer collectionServer;
    public RemoveGreaterCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }

    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        collectionServer.removeGreater();
    }
}
