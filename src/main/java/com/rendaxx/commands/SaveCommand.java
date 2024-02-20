package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.NoFileException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class SaveCommand extends Command {
    private static final String NAME = "save";
    private static final String ARGS = "";
    private static final String DESC = "saves collection in csv format";

    CollectionServer collectionServer;
    public SaveCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    @Override
    public void run(String[] args) {
        try {
            collectionServer.save();
        } catch (NoFileException e) {
            System.err.println("You can't use this command.");
        }

    }
}
