package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
/**
 * Class for show command. This command prints collection's elements.
 * @see CollectionServer
 */
public class ShowCommand extends Command {
    private static final String NAME = "show";
    private static final String ARGS = "";
    private static final String DESC = "prints collection's elements";

    final CollectionServer collectionServer;
    public ShowCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Prints collection's elements.
     * @param args arguments for command
     */
    @Override
    public void run(String[] args) {
        collectionServer.collectionShow();
    }
}
