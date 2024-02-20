package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class PrintAscendingFullCommand extends Command {
    private static final String NAME = "print_field_ascending_full_name";
    private static final String ARGS = "";
    private static final String DESC = "prints all fullNames sorted";

    CollectionServer collectionServer;
    public PrintAscendingFullCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }

    @Override
    public void run(String[] args) {
        collectionServer.printsAscending();
    }
}
