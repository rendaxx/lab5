package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;
/**
 * Class for remove_lower command. This command removes all elements lower that {element}.
 * @see CollectionServer
 */
public class RemoveLowerCommand extends Command {
    private static final String NAME = "remove_greater";
    private static final String ARGS = "{element}";
    private static final String DESC = "removes all elements greater that {element}";

    final CollectionServer collectionServer;
    public RemoveLowerCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Removes all elements lower that {element}.
     * @param args arguments for command
     * @throws InvalidArgumentCountException if argument count is incorrect
     * @throws WrongInputException if input is incorrect
     */
    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        if (args != null) {
            throw new WrongInputException("Wrong amount of args");
        }
        collectionServer.removeLower();
    }
}
