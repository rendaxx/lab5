package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
/**
 * Class for clear command. This command clears collection managed by CollectionServer.
 * @see CollectionServer
 */
public class ClearCommand extends Command {
    private static final String NAME = "clear";
    private static final String ARGS = "";
    private static final String DESC = "clears collection";

    final CollectionServer collectionServer;
    public ClearCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Clears collection managed by CollectionServer.
     * @param args arguments for command
     */
    @Override
    public void run(String[] args) {
        collectionServer.clearCollection();
    }
}
