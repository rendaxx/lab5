package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.NoFileException;
/**
 * Class for save command. This command saves collection in csv format.
 * @see CollectionServer
 */
public class SaveCommand extends Command {
    private static final String NAME = "save";
    private static final String ARGS = "";
    private static final String DESC = "saves collection in csv format";

    final CollectionServer collectionServer;
    public SaveCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Saves collection in csv format.
     * @param args arguments for command
     */
    @Override
    public void run(String[] args) {
        try {
            collectionServer.save();
        } catch (NoFileException e) {
            System.err.println("You can't use this command.");
        }

    }
}
