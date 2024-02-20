package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class ShowCommand extends Command {
    private static final String NAME = "show";
    private static final String ARGS = "";
    private static final String DESC = "prints collection's elements";

    CollectionServer collectionServer;
    public ShowCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    @Override
    public void run(String[] args) {
        collectionServer.collectionShow();
    }
}
