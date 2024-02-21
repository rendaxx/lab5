package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;
/**
 * Class for update command. This command updates element by his id.
 * @see CollectionServer
 */
public class UpdateCommand extends Command{
    private static final String NAME = "update";
    private static final String ARGS = "id {element}";
    private static final String DESC = "updates element by his id";

    final CollectionServer collectionServer;
    public UpdateCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Updates element by his id.
     * @param args arguments for command
     * @throws InvalidArgumentCountException if argument count is incorrect
     * @throws WrongInputException if input is incorrect
     */
    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        if (args.length != 1) {
            throw new WrongInputException("Wrong amount of args");
        }
        long id;
        try {
            id = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            throw new WrongInputException();
        }
        collectionServer.updateElement(id);
    }
}
