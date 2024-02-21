package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;
/**
 * Class for add_if_min command. This command adds element in collection managed by CollectionServer if its value is lower than collection's minimum.
 * @see CollectionServer
 */
public class AddIfMinCommand extends Command {
    private static final String NAME = "add_if_min";
    private static final String ARGS = "{element}";
    private static final String DESC = "adds {element} in collection if its value is lower than collection's minimum";

    final CollectionServer collectionServer;
    public AddIfMinCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Adds element in collection managed by CollectionServer if its value is lower than collection's minimum.
     * @param args arguments for command
     * @throws IOException if an I/O error occurs
     * @throws WrongInputException if input is incorrect
     */
    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        collectionServer.addIfMin();
    }
}
