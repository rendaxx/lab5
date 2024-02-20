package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class UpdateCommand extends Command{
    private static final String NAME = "update";
    private static final String ARGS = "id {element}";
    private static final String DESC = "updates element by his id";

    CollectionServer collectionServer;
    public UpdateCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        if (args.length != 1) {
            throw new InvalidArgumentCountException();
        }
        Long id;
        try {
            id = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            throw new WrongInputException();
        }
        collectionServer.updateElement(id);
    }
}
