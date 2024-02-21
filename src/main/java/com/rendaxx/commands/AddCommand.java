package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

/**
 * Class for add command. This command adds element in collection managed by CollectionServer.
 * @see CollectionServer
 */
public class AddCommand extends Command {
    private static final String NAME = "add";
    private static final String ARGS = "{element}";
    private static final String DESC = "adds element in collection";

    final CollectionServer collectionServer;
    public AddCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Adds element in collection managed by CollectionServer.
     * @param args arguments for command
     * @throws IOException if an I/O error occurs
     * @throws WrongInputException if input is incorrect
     */
    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        if (args != null) {
            throw new WrongInputException("Wrong amount of args");
        }
        collectionServer.addElement();
    }
}
