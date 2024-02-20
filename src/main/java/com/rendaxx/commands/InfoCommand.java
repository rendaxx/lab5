package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class InfoCommand extends Command {
    private static final String NAME = "info";
    private static final String ARGS = "";
    private static final String DESC = "prints collection's info";

    final CollectionServer collectionServer;
    public InfoCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    @Override
    public void run(String[] args) {
        collectionServer.collectionInfo();
    }
}
