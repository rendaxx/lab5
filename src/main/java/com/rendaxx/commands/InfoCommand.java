package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
/**
 * Class for info command. This command prints collection's info.
 * @see CollectionServer
 */
public class InfoCommand extends Command {
    private static final String NAME = "info";
    private static final String ARGS = "";
    private static final String DESC = "prints collection's info";

    final CollectionServer collectionServer;
    public InfoCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Prints collection's info.
     * @param args arguments for command
     */
    @Override
    public void run(String[] args) {
        collectionServer.collectionInfo();
    }
}
