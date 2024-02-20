package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class ClearCommand extends Command {
    private static final String NAME = "clear";
    private static final String ARGS = "";
    private static final String DESC = "clears collection";

    final CollectionServer collectionServer;
    public ClearCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }

    @Override
    public void run(String[] args) {
        collectionServer.clearCollection();
    }
}
