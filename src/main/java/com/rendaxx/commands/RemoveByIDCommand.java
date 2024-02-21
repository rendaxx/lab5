package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;
/**
 * Class for remove_by_id command. This command removes element by his id.
 * @see CollectionServer
 */
public class RemoveByIDCommand extends Command {
    private static final String NAME = "remove_by_id";
    private static final String ARGS = "id";
    private static final String DESC = "removes element by his id";

    final CollectionServer collectionServer;
    public RemoveByIDCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Removes element by his id.
     * @param args arguments for command
     * @throws InvalidArgumentCountException if argument count is incorrect
     * @throws WrongInputException if input is incorrect
     */
    @Override
    public void run(String[] args) throws InvalidArgumentCountException, WrongInputException {
        if (args.length != 1) {
            throw new InvalidArgumentCountException();
        }
        long id;
        try {
            id = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            throw new WrongInputException();
        }
        collectionServer.removeElementById(id);
    }
}
