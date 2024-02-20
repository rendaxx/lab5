package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class AddCommand extends Command {
    private static final String NAME = "add";
    private static final String ARGS = "{element}";
    private static final String DESC = "adds element in collection";

    final CollectionServer collectionServer;
    public AddCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }

    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        collectionServer.addElement();
    }
}
