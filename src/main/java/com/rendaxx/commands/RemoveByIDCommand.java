package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class RemoveByIDCommand extends Command {
    private static final String NAME = "remove_by_id";
    private static final String ARGS = "id";
    private static final String DESC = "removes element by his id";

    CollectionServer collectionServer;
    public RemoveByIDCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }

    @Override
    public void run(String[] args) throws InvalidArgumentCountException, WrongInputException {
        if (args.length != 1) {
            throw new InvalidArgumentCountException();
        }
        Long id;
        try {
            id = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            throw new WrongInputException();
        }
        collectionServer.removeElementById(id);
    }
}
