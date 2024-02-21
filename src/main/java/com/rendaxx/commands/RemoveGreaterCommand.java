package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;
/**
 * Class for remove_greater command. This command removes all elements greater that {element}.
 * @see CollectionServer
 */
public class RemoveGreaterCommand extends Command {
    private static final String NAME = "remove_greater";
    private static final String ARGS = "{element}";
    private static final String DESC = "removes all elements greater that {element}";

    final CollectionServer collectionServer;
    public RemoveGreaterCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Removes all elements greater that {element}.
     * @param args arguments for command
     * @throws InvalidArgumentCountException if argument count is incorrect
     * @throws WrongInputException if input is incorrect
     */
    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        if (args != null) {
            throw new WrongInputException("Wrong amount of args");
        }
        collectionServer.removeGreater();
    }
}
